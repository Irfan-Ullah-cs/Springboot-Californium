package com.example.coap_client.runner;


import com.example.coap_client.service.CoapClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoapClientRunner implements CommandLineRunner {

    private final CoapClientService coapClientService;

    public CoapClientRunner(CoapClientService coapClientService) {
        this.coapClientService = coapClientService;
    }

    @Override
    public void run(String... args) throws Exception {
        coapClientService.sendCoapRequest();
    }
}
