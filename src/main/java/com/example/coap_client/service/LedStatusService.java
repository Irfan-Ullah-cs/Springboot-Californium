package com.example.coap_client.service;


import com.example.coap_client.DTO.LedStatusDTO;
import com.example.coap_client.Entity.LedStatus;
import com.example.coap_client.Repository.LedStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LedStatusService {
    @Autowired
    private LedStatusRepository ledStatusRepository;

    public LedStatus updateLedStatus(LedStatusDTO ledStatusDTO) {
        LedStatus ledStatus = ledStatusRepository.findById(1L).orElse(new LedStatus());
        ledStatus.setRedLed(ledStatusDTO.isRedLed());
        ledStatus.setYellowLed(ledStatusDTO.isYellowLed());
        ledStatus.setGreenLed(ledStatusDTO.isGreenLed());
        return ledStatusRepository.save(ledStatus);
    }

    public LedStatus getLedStatus() {
        return ledStatusRepository.findById(1L).orElse(new LedStatus());
    }
}
