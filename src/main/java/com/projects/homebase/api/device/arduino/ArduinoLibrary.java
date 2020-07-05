package com.projects.homebase.api.device.arduino;

import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.Library;

import java.util.List;

public class ArduinoLibrary extends Library {


    @Override
    public void addDevice(DeviceDetails deviceDetails) {
        Device device = new Arduino();

        /**
         * TODO:LOGIC convert DeviceDetails into Device
         * Might need to be segregated into Utlity function
         */

    }
}
