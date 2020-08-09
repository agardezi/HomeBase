package com.projects.homebase.api.workerflow.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.dto.RequestDTO;

/**
 * Class maps the request_body to Device Details obj
 */
public class JsonDeviceDetailsMapper {


    public DeviceDetails process(RequestDTO requestDTO) throws JsonProcessingException {
        DeviceDetails deviceDetails = null;
        try{
            String temp = requestDTO.getAttribute(HomeBaseCommonConstant.REQUEST_BODY).toString();
            ObjectMapper mapper = new ObjectMapper();
            deviceDetails = mapper.readValue(requestDTO.getAttribute(HomeBaseCommonConstant.REQUEST_BODY).toString(),DeviceDetails.class);
        }
        catch (Exception e){
            //TODO: Exception Handling
        }
        return deviceDetails;

    }
}
