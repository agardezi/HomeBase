package com.projects.homebase.api.controller;

import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.Device;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.InvokeRequestDetails;
import com.projects.homebase.api.model.dto.RequestDTO;
import com.projects.homebase.api.registry.Registry;
import com.projects.homebase.api.workerflow.ExternalRequestBuilder;
import com.projects.homebase.api.workerflow.JsonDeviceDetailsMapper;
import com.projects.homebase.api.workerflow.JsonInvokeRequestDetailsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Class will define endpoints
 *  - Initialize device
 *  - Invoke Device action
 *  - Get all devices and relative actions in json for the UI
 */

@RestController
@RequestMapping(path = "/device/")
public class DeviceController {
    Registry deviceRegistry = Registry.getInstance();

    @PostMapping(path = "/initialize")
    public ResponseEntity<Object> initializeDevice(@RequestHeader(HomeBaseCommonConstant.DEVICE_TYPE) String deviceType,
                                                      @RequestBody String newDevice) throws Exception {

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
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().body("PLACEHOLDER");
        return responseEntity;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<Object> getAllDevices() throws Exception {


        /**
         *
         */


        // TODO: Parse library and construct JSON with all devices and send as response
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().body("DEVICES: ..");
        return responseEntity;
    }
}
