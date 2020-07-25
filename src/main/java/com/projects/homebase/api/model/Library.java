package com.projects.homebase.api.model;

import com.projects.homebase.api.factory.DeviceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class Library {


    private DeviceFactory deviceFactory = new DeviceFactory();
    private List<Device> devices = new ArrayList<Device>();


    public void addDevice(DeviceDetails deviceDetails){
        Device device = deviceFactory.create(deviceDetails.getDeviceType());
        device.setName(deviceDetails.getName());
        device.setIpAddr(deviceDetails.getIpAddr());
        for(ActionSummary ac: deviceDetails.getActionSummary()){
            device.addAction(ac);
        }
        devices.add(device);

    }
    public Device getDevice(String deviceName){
        for(Device device: devices){
            if(device.getName().equals(deviceName))
                return device;
        }
        // TODO: Error Handling
        return null;
    }

}
