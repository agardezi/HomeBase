package com.projects.homebase.api.controller;

import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.request.InvokeRequestDetails;
import com.projects.homebase.api.model.dto.RequestDTO;
import com.projects.homebase.api.registry.Registry;
import com.projects.homebase.api.service.ResponseBuilderService;
import com.projects.homebase.api.workerflow.ExternalRequestBuilder;
import com.projects.homebase.api.workerflow.mapper.JsonDeviceDetailsMapper;
import com.projects.homebase.api.workerflow.mapper.JsonInvokeRequestDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Class will define endpoints
 *  - Initialize device
 *  - Invoke Device action
 *  - Get all devices and relative actions in json for the UI
 */

@RestController
@RequestMapping(path = "/device")
public class DeviceController {
    Registry deviceRegistry = Registry.getInstance();

    @Autowired
    ResponseBuilderService responseBuilderService;


    @PostMapping(path = "/initialize")
    public ResponseEntity<Object> initializeDevice(@RequestHeader(HomeBaseCommonConstant.DEVICE_TYPE) String deviceType,
                                                      @RequestBody String newDevice) throws Exception {

        System.out.println(newDevice);
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setAttribute(HomeBaseCommonConstant.DEVICE_TYPE,deviceType);
        requestDTO.setAttribute(HomeBaseCommonConstant.REQUEST_BODY,newDevice);

        JsonDeviceDetailsMapper jsonDeviceDetailsMapper = new JsonDeviceDetailsMapper();
        DeviceDetails deviceDetails = jsonDeviceDetailsMapper.process(requestDTO);
        deviceRegistry.register(deviceDetails);


        /**
         *
         */


        // TODO: Update return response entity with message corresponding to event
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().body("Device Successfully Initialized");
        return responseEntity;
    }

    @PostMapping(path = "/invoke")
    public ResponseEntity<Object> invoke(@RequestHeader((HomeBaseCommonConstant.DEVICE_TYPE)) String deviceType,
                                                   @RequestBody String invokeRequest) throws Exception {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setAttribute(HomeBaseCommonConstant.DEVICE_TYPE,deviceType);
        requestDTO.setAttribute(HomeBaseCommonConstant.REQUEST_BODY,invokeRequest);

        JsonInvokeRequestDetailsMapper jsonInvokeRequestDetailsMapper = new JsonInvokeRequestDetailsMapper();
        InvokeRequestDetails requestDetails = jsonInvokeRequestDetailsMapper.process(requestDTO);



        ExternalRequestBuilder externalRequestBuilder = new ExternalRequestBuilder();
        HttpURLConnection con = externalRequestBuilder.build(
                deviceRegistry.getLibrary(requestDetails.getDeviceType()).getDevice(requestDetails.getDeviceName()),
                requestDetails.getActionName(),
                requestDetails.getPayload());

        /*
        Following code chunk was found on https://www.baeldung.com/java-http-request
         */
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();








        /**
         * - Use Request Builder to build http request
         * - trigger request
         * - return reponse from server to client
         */




        /**
         *
         */


        // TODO: Update return response that is received from respective device
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().body("PLACEHOLDER: It probably worked");
        return responseEntity;
    }

    @GetMapping(path = "/getDevices")
    public ResponseEntity<Object> getAllDevices() throws Exception {


        /**
         * Get All Libraries
         * For Each Library:
         *  - process Device and add it to DeviceRegistry object
         */
        responseBuilderService.processDevice();

        List<Device> registeredDevices = new ArrayList<>();
        registeredDevices.addAll(deviceRegistry.getLibrary(HomeBaseCommonConstant.ARDUINO).getAllDevices());
        registeredDevices.addAll(deviceRegistry.getLibrary(HomeBaseCommonConstant.PI).getAllDevices());
        System.out.println(registeredDevices.toString());



//        RegisteredDevices registeredDevices = new RegisteredDevices();
        // TODO: Parse library and construct JSON with all devices and send as response
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().body(responseBuilderService.getDevices());
        return responseEntity;
    }
}
