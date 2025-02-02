package com.example.coap_client.service;


import com.example.coap_client.DTO.SensorDataDTO;
import com.example.coap_client.Entity.SensorData;
import com.example.coap_client.Repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SensorDataService {
    @Autowired
    private SensorDataRepository sensorDataRepository;

    public SensorData saveSensorData(SensorDataDTO sensorDataDTO) {
        SensorData sensorData = new SensorData();
        sensorData.setTemperature(sensorDataDTO.getTemperature());
        sensorData.setHumidity(sensorDataDTO.getHumidity());
        sensorData.setTimestamp(String.valueOf(LocalDateTime.now()));
        return sensorDataRepository.save(sensorData);
    }
}