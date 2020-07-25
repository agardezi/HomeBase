package com.projects.homebase.api.workerflow;

import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.action.Action;
import com.projects.homebase.api.model.action.QueryAction;
import com.projects.homebase.api.service.RequestBuilderService;
import org.apache.catalina.filters.ExpiresFilter;

import java.net.HttpURLConnection;

/**
 * Generates Request based on generic request made to server
 * -- Will leverage RequestBuilderService to get actualy http request
 * -- passed in Device  and payload, takes what is needed and passes it into RequestBuilderService
 */
public class ExternalRequestBuilder {

    // Needs to be a return type of http request maybe or  Entity probably
    public HttpURLConnection build(Device device, String actionName, Object payload){
        try {

            String deviceIpAddr = device.getIpAddr();
            Action action = device.getAction(actionName);
            String actionType = action.getClass().getName();
            String endpoint = action.getEndpoint();

            if (HomeBaseCommonConstant.ActionClassType.QUERY.value.equals(actionType)) {
                return RequestBuilderService.generateQueryRequest(deviceIpAddr, endpoint, payload);
            }
            if (HomeBaseCommonConstant.ActionClassType.PATH.value.equals(actionType)) {
                return RequestBuilderService.generatePathRequest(deviceIpAddr, endpoint, payload);
            }
            if (HomeBaseCommonConstant.ActionClassType.REQUEST_BODY.value.equals(actionType)) {
                return RequestBuilderService.generateRequestBodyRequest(deviceIpAddr, endpoint, payload);
            }
        }
        catch (Exception e){
            //TODO: Exception Handling
        }
        // TODO: handle case where request type does not exist, don't return null
        return null;

    }


}
