package com.fleet.fleet_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Application Health", description = "Application health and version APIs")
@RestController
public class HealthController {

	@Operation(summary = "Application Home")
	@GetMapping("/")
	public String home() {
		return "Fleet Management and Route Optimization Engine is Running Successfully!";
	}

	@Operation(summary = "Application Health Status")
	@GetMapping("/health")
	public String health() {
		return "Application Status : UP";
	}

	@Operation(summary = "Application Version")
	@GetMapping("/version")
	public String version() {
		return "Fleet Management API v1.0";
	}
}