package com.projects.homebase.api.service;

import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.action.Action;
import com.projects.homebase.api.model.action.PathAction;
import com.projects.homebase.api.model.action.QueryAction;
import com.projects.homebase.api.model.action.RequestBodyAction;
import com.projects.homebase.api.util.ParameterStringBuilder;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Map;

/**
 * Resource: https://www.baeldung.com/java-http-request
 */

@Component("requestBuilderService")
public class RequestBuilderService {

    public void print(){
        System.out.println("Successfully AutoWired");
    }
    /**
     * Create http request
     * return request

     */



    public static HttpURLConnection generateQueryRequest(String baseUrl, String endpoint, Object payload) throws UnsupportedEncodingException {
        System.out.println("Running Generate Request for query action");

        String queries = ParameterStringBuilder.getParamsString((Map<String, String>) payload);

        System.out.println(baseUrl + endpoint + "?" +  queries);


        return null;
    }

    public static HttpURLConnection generatePathRequest(String baseUrl, String endpoint, Object payload){
        System.out.println("Running Generate Request for path action");

        return null;

    }

    public static HttpURLConnection generateRequestBodyRequest(String baseUrl, String endpoint,  Object payload){
        System.out.println("Running Generate Request for requestbody action");

        return null;
    }
}
