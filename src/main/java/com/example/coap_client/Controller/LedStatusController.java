package com.example.coap_client.Controller;


import com.example.coap_client.DTO.LedStatusDTO;
import com.example.coap_client.Entity.LedStatus;
import com.example.coap_client.service.LedStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/led-status")
public class LedStatusController {
    @Autowired
    private LedStatusService ledStatusService;

    @GetMapping
    public LedStatus getLedStatus() {
        return ledStatusService.getLedStatus();
    }

    @PostMapping
    public LedStatus updateLedStatus(@RequestBody LedStatusDTO ledStatusDTO) {
        return ledStatusService.updateLedStatus(ledStatusDTO);
    }
}
