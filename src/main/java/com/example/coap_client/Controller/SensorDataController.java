package com.example.coap_client.Controller;


import com.example.coap_client.DTO.SensorDataDTO;
import com.example.coap_client.Entity.SensorData;
import com.example.coap_client.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {
    @Autowired
    private SensorDataService sensorDataService;

    @PostMapping
    public SensorData saveSensorData(@RequestBody SensorDataDTO sensorDataDTO) {
        return sensorDataService.saveSensorData(sensorDataDTO);
    }
}
