package com.projects.homebase.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.Library;
import com.projects.homebase.api.model.response.GetDevicesResponse;
import com.projects.homebase.api.registry.Registry;
import com.projects.homebase.api.util.ObjectStringBuilder;
import com.projects.homebase.api.workerflow.mapper.JsonGetDevicesResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("responseBuilderService")
public class ResponseBuilderService {
    @Autowired
    JsonGetDevicesResponseMapper jsonMapper;

    private List<GetDevicesResponse> devices = new ArrayList<>();


    Registry deviceRegistry = Registry.getInstance();

    public List<GetDevicesResponse> getDevices(){
        return devices;
    }

    public void processDevice() throws JsonProcessingException {
       devices = new ArrayList<>();
       Gson gson = new Gson();
       for(Device device: deviceRegistry.getLibrary(HomeBaseCommonConstant.ARDUINO).getAllDevices()){
           GetDevicesResponse singleDevice = jsonMapper.process(gson.toJson(device));
           devices.add(singleDevice);
        }
    }











}
