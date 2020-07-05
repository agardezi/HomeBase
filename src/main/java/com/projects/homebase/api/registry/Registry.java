package com.projects.homebase.api.registry;

import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.Library;
import java.util.Map;

/**
 * Singleton class that will hold all libraries in it.
 */
public class Registry {

    private Map<String, Library> Libraries;

    private static Registry instance = new Registry();

    private Registry(){
        // Initialize map
    }

    public static Registry getInstance(){
        return instance;
    }
    public void register(DeviceDetails deviceDetails){

    }

}
