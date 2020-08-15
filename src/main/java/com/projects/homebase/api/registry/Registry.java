package com.projects.homebase.api.registry;

import com.projects.homebase.HomebaseApplication;
import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.device.arduino.ArduinoLibrary;
import com.projects.homebase.api.device.pi.PiLibrary;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class that will hold all libraries in it.
 */
@Component
public class Registry {

    private static final Logger LOGGER = LoggerFactory.getLogger(Registry.class);



    private Map<String, Library> Libraries;

    private static Registry instance = new Registry();

    private Registry(){
        // Initialize map
        Libraries = new HashMap<>();
        Library arduinoLibrary = new ArduinoLibrary();
        Library piLibrary = new PiLibrary();
        Libraries.put(HomeBaseCommonConstant.ARDUINO,arduinoLibrary);
        Libraries.put(HomeBaseCommonConstant.PI,piLibrary);

    }

    public static Registry getInstance(){
        return instance;
    }

    // get's library based on device_type value, adds device to corresponding library
    public void register(DeviceDetails deviceDetails){
        LOGGER.info("Inside Registry.register method");
        Libraries.get(deviceDetails.getDeviceType()).addDevice(deviceDetails);
        LOGGER.info("End of Registry.register method");

    }
    public Library getLibrary(String libraryName){
        return Libraries.get(libraryName);
    }
    public Map<String,Library> getLibraries(){
        return Libraries;
    }




}
