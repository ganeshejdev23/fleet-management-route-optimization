package com.fleet.fleet_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/")
	public String home() {
		return "Fleet Management and Route Optimization Engine is Running Successfully!";
	}

	@GetMapping("/health")
	public String health() {
		return "Application Status : UP";
	}

	@GetMapping("/version")
	public String version() {
		return "Fleet Management API v1.0";
	}
}