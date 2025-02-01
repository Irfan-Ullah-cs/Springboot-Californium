package com.example.coap_client.service;

import com.example.coap_client.Entity.SensorData;
import com.example.coap_client.Repository.SensorDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.config.CoapConfig;
import org.eclipse.californium.elements.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
public class CoapClientService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private SensorDataRepository sensorDataRepository;

    /**
     * Sends a CoAP GET request to the specified URI, processes the response, and saves it to the database.
     */
    @Scheduled(fixedRate = 5000) // Run every 5 seconds
    public void sendCoapRequest() {
        try {
            // Hardcoded CoAP server URI
            String uri = "coap://192.168.152.226/sensors";

            // Initialize the configuration programmatically
            Configuration config = new Configuration();
            config.set(CoapConfig.COAP_PORT, 5683); // Default CoAP port
            config.set(CoapConfig.MAX_MESSAGE_SIZE, 8192); // Max message size
            config.set(CoapConfig.ACK_TIMEOUT, 2000, TimeUnit.MILLISECONDS); // ACK timeout in milliseconds

            // Create the CoAP client
            CoapClient client = new CoapClient(uri);

            // Send a GET request
            CoapResponse response = client.get();

            // Handle the response
            if (response != null) {
                if (response.isSuccess()) {
                    String jsonResponse = response.getResponseText();
                    System.out.println("Received CoAP response: " + jsonResponse);

                    // Parse the JSON response into a SensorData object
                    SensorData sensorData = objectMapper.readValue(jsonResponse, SensorData.class);

                    // Save the SensorData object to the database
                    sensorDataRepository.save(sensorData);
                    System.out.println("Saved Sensor Data: " + sensorData);
                } else {
                    System.err.println("CoAP request failed with code: " + response.getCode());
                }
            } else {
                System.err.println("No response received from CoAP server");
            }
        } catch (Exception e) {
            System.err.println("Error while sending CoAP request: " + e.getMessage());
            e.printStackTrace();
        }
    }
}