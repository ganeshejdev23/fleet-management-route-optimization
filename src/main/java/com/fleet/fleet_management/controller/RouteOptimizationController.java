package com.fleet.fleet_management.controller;

import com.fleet.fleet_management.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;
import com.fleet.fleet_management.dto.RouteRequestDto;
import com.fleet.fleet_management.dto.OptimizedRouteResponseDto;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

	private final RouteOptimizationService service;

	public RouteOptimizationController(RouteOptimizationService service) {

		this.service = service;
	}

	@PostMapping("/sequence")
	public OptimizedRouteResponseDto optimizeSequence(

			@RequestBody RouteRequestDto request) {

		return new OptimizedRouteResponseDto(

				service.optimizeRoute(request.getLocations()));
	}

	@GetMapping
	public String optimizeRoute(

			@RequestParam double startLon, @RequestParam double startLat, @RequestParam double endLon,
			@RequestParam double endLat) {

		return service.getRouteData(startLon, startLat, endLon, endLat);
	}
}