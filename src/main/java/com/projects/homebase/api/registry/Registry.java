package com.projects.homebase.api.registry;

import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.device.arduino.ArduinoLibrary;
import com.projects.homebase.api.device.pi.PiLibrary;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.Library;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class that will hold all libraries in it.
 */
public class Registry {

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
        Libraries.get(deviceDetails.getDeviceType()).addDevice(deviceDetails);

    }

}
