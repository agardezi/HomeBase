package com.projects.homebase.api.controller;

import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.DeviceDetails;
import com.projects.homebase.api.model.dto.RequestDTO;
import com.projects.homebase.api.registry.Registry;
import com.projects.homebase.api.workerflow.JsonDeviceDetailsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class will define endpoints
 *  - Initialize device
 *  - Invoke Device action
 *  - Get all devices and relative actions in json for the UI
 */

@RestController
@RequestMapping(path = "/device/")
public class DeviceController {

    @PostMapping(path = "/initialize")
    public ResponseEntity<Object> initializeDevice(@RequestHeader(HomeBaseCommonConstant.DEVICE_TYPE) String deviceType,
                                                      @RequestBody String newDevice) throws Exception {

        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setAttribute(HomeBaseCommonConstant.DEVICE_TYPE,deviceType);
        requestDTO.setAttribute(HomeBaseCommonConstant.REQUEST_BODY,newDevice);

        JsonDeviceDetailsMapper jsonDeviceDetailsMapper = new JsonDeviceDetailsMapper();
        DeviceDetails deviceDetails = jsonDeviceDetailsMapper.process(requestDTO);

        Registry deviceRegistry = Registry.getInstance();
        deviceRegistry.register(deviceDetails);


        /**
         *
         */


        // TODO: Update return response entity with message corresponding to event
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().body("Device Successfully Initialized");
        return responseEntity;
    }

    @PostMapping(path = "/invoke")
    public ResponseEntity<Object> invoke(@RequestHeader("device_type") String deviceType,
                                                   @RequestBody String payload) throws Exception {


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
