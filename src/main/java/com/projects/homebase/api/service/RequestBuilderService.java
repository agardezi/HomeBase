package com.projects.homebase.api.service;

import com.projects.homebase.api.controller.DeviceController;
import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.action.Action;
import com.projects.homebase.api.model.action.PathAction;
import com.projects.homebase.api.model.action.QueryAction;
import com.projects.homebase.api.model.action.RequestBodyAction;
import com.projects.homebase.api.util.ParameterStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Resource: https://www.baeldung.com/java-http-request
 */

@Component("requestBuilderService")
public class RequestBuilderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);


    public static HttpURLConnection generateQueryRequest(String baseUrl, String endpoint, Object payload) throws IOException {
        System.out.println("Running Generate Request for query action");

        String queries = ParameterStringBuilder.getParamsString((Map<String, String>) payload);
        System.out.println(baseUrl + endpoint + "?" +  queries);

        URL url = new URL("http://" + baseUrl + endpoint + "?" +  queries);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");


        return connection;
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
