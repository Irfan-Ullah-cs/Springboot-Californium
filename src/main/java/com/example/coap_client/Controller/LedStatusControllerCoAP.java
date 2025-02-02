package com.example.coap_client.Controller;


import com.example.coap_client.Entity.LedStatus;
import com.example.coap_client.Repository.LedStatusRepository;
import org.eclipse.californium.core.CoapResource;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LedStatusControllerCoAP extends CoapResource {
    @Autowired
    private LedStatusRepository ledStatusRepository;

    public LedStatusControllerCoAP() {
        super("led-status"); // Resource name
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        // Fetch the latest LED status from the database
        LedStatus latestStatus = ledStatusRepository.findTopByOrderByTimestampDesc();

        if (latestStatus != null) {
            // Convert the LED status to JSON
            String jsonResponse = String.format(
                    "{\"redLed\": %b, \"yellowLed\": %b, \"greenLed\": %b}",
                    latestStatus.isRedLed(),
                    latestStatus.isYellowLed(),
                    latestStatus.isGreenLed()
            );

            // Send the response
            exchange.respond(CoAP.ResponseCode.CONTENT, jsonResponse);
        } else {
            exchange.respond(CoAP.ResponseCode.NOT_FOUND, "No LED status found");
        }
    }

}