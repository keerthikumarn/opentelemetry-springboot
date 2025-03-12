package com.opentelemetry.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/telemetry-service")
public class OpenTelemetryController {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	private RestTemplate restTemplate;

	@Value("${spring.application.name}")
	private String applicationName;

	public OpenTelemetryController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/trace1")
	public ResponseEntity<String> trace1() {
		logger.info("Inside trace1 method of OpenTelemetryController");
		String response = restTemplate.getForObject("http://localhost:8080/telemetry-service/trace2", String.class);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/trace2")
	public ResponseEntity<String> trace2() {
		logger.info("Inside trace2 method of OpenTelemetryController");
		return ResponseEntity.ok("Hello from trace2 method of OpenTelemetryController");
	}
}
