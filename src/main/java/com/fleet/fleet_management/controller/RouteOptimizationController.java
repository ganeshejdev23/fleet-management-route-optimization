package com.fleet.fleet_management.controller;

import com.fleet.fleet_management.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

	private final RouteOptimizationService service;

	public RouteOptimizationController(RouteOptimizationService service) {

		this.service = service;
	}

	@GetMapping
	public String optimizeRoute(

			@RequestParam double startLon, @RequestParam double startLat, @RequestParam double endLon,
			@RequestParam double endLat) {

		return service.getRouteData(startLon, startLat, endLon, endLat);
	}
}