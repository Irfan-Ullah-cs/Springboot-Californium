package com.example.coap_client;

import com.example.coap_client.Controller.LedStatusController;
import jakarta.annotation.PostConstruct;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.config.CoapConfig;
import org.eclipse.californium.elements.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class CoapClientApplication {

	@Autowired
	private LedStatusController ledStatusController;

	public static void main(String[] args) {
		SpringApplication.run(CoapClientApplication.class, args);
	}

	@PostConstruct
	public void startCoapServer() {
		// Create a new configuration
		Configuration config = new Configuration();

		// Set custom configuration values
		config.set(CoapConfig.COAP_PORT, 5683); // Default CoAP port
		config.set(CoapConfig.MAX_MESSAGE_SIZE, 8192); // Max message size
		config.set(CoapConfig.ACK_TIMEOUT, 2000, TimeUnit.MILLISECONDS); // ACK timeout in milliseconds

		// Create the CoAP server with the custom configuration
		CoapServer coapServer = new CoapServer(config);

		// Add the LED status resource
		coapServer.add(ledStatusController);

		// Start the CoAP server
		coapServer.start();
		System.out.println("CoAP server started for LED status on port 5683");
	}
}