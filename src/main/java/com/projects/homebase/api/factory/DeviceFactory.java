package com.projects.homebase.api.factory;

import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.device.arduino.Arduino;
import com.projects.homebase.api.device.pi.Pi;
import com.projects.homebase.api.model.Device;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class DeviceFactory {

    public Device create(String name) {
        switch (name) {
            case HomeBaseCommonConstant.ARDUINO:
                return new Arduino();
            case HomeBaseCommonConstant.PI:
                return new Pi();

        }
        //TODO: Exception handling SHOULD NEVER RETURN NULL
        return null;
    }

}
