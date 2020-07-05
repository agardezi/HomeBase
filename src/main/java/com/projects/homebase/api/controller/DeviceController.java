package com.projects.homebase.api.controller;

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
    public ResponseEntity<Object> initializeDevice(@RequestHeader("device_type") String deviceType,
                                                      @RequestBody String newDevice) throws Exception {

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
