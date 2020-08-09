package com.projects.homebase.api.workerflow.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.dto.RequestDTO;
import com.projects.homebase.api.model.response.GetDevicesResponse;
import org.springframework.stereotype.Component;

@Component("jsonGetDevicesResponseMapper")
public class JsonGetDevicesResponseMapper {
    public GetDevicesResponse process(String device) throws JsonProcessingException {
        GetDevicesResponse getDevicesResponse = null;
        try{
            // Needed to add config so that mapping doesnt fail if unrecognized class
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            getDevicesResponse = mapper.readValue(device, GetDevicesResponse.class);
        }
        catch (Exception e){
            //TODO: Exception Handling
        }
        return getDevicesResponse;

    }
}
