package com.fleet.fleet_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleet_management.dto.OptimizedRouteResponseDto;
import com.fleet.fleet_management.dto.RouteRequestDto;
import com.fleet.fleet_management.dto.RouteSummaryDto;
import com.fleet.fleet_management.service.RouteOptimizationService;

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

	@GetMapping("/nearest")
	public List<String> nearestRoute() {

		return service.optimizeNearestRoute();
	}

	@GetMapping("/summary")
	public RouteSummaryDto getRouteSummary() {

		return service.generateRouteSummary();
	}
}