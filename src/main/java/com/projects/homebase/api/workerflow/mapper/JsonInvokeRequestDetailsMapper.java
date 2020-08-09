package com.projects.homebase.api.workerflow.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.request.InvokeRequestDetails;
import com.projects.homebase.api.model.dto.RequestDTO;


public class JsonInvokeRequestDetailsMapper {
    public InvokeRequestDetails process(RequestDTO requestDTO) throws JsonProcessingException {
        InvokeRequestDetails invokeRequestDetails = null;
        try{
            ObjectMapper mapper = new ObjectMapper();
            invokeRequestDetails = mapper.readValue(requestDTO.getAttribute(HomeBaseCommonConstant.REQUEST_BODY).toString(),InvokeRequestDetails.class);
        }
        catch (Exception e){
            //TODO: Exception Handling
        }
        return invokeRequestDetails;

    }
}
