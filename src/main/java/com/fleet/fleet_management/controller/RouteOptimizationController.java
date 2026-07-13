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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Route Optimization", description = "APIs for optimizing delivery routes and distance calculations")
@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

	private final RouteOptimizationService service;

	public RouteOptimizationController(RouteOptimizationService service) {

		this.service = service;
	}

	@Operation(summary = "Optimize delivery sequence")
	@PostMapping("/sequence")
	public OptimizedRouteResponseDto optimizeSequence(

			@RequestBody RouteRequestDto request) {

		return new OptimizedRouteResponseDto(

				service.optimizeRoute(request.getLocations()));
	}

	@Operation(summary = "Get optimized route")
	@GetMapping
	public String optimizeRoute(

			@RequestParam double startLon, @RequestParam double startLat, @RequestParam double endLon,
			@RequestParam double endLat) {

		return service.getRouteData(startLon, startLat, endLon, endLat);
	}

	@Operation(summary = "Get optimization summary")
	@GetMapping("/nearest")
	public List<String> nearestRoute() {

		return service.optimizeNearestRoute();
	}

	@Operation(summary = "Find nearest delivery point")
	@GetMapping("/summary")
	public RouteSummaryDto getRouteSummary() {

		return service.generateRouteSummary();
	}
}