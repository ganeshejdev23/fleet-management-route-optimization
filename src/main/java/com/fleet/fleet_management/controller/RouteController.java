package com.fleet.fleet_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleet_management.entity.Route;
import com.fleet.fleet_management.service.RouteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Route Management", description = "APIs for managing routes")
@RestController
@RequestMapping("/routes")
public class RouteController {

	private final RouteService routeService;

	public RouteController(RouteService routeService) {

		this.routeService = routeService;
	}

	@Operation(summary = "Create route")
	@PostMapping
	public Route createRoute(@RequestBody Route route) {

		return routeService.saveRoute(route);
	}

	@Operation(summary = "Get all routes")
	@GetMapping
	public List<Route> getAllRoutes() {
		return routeService.getAllRoutes();
	}

	@Operation(summary = "Get route by ID")
	@GetMapping("/{id}")
	public Route getRouteById(@PathVariable Long id) {

		return routeService.getRouteById(id);
	}

	@Operation(summary = "Delete route")
	@DeleteMapping("/{id}")
	public void deleteRoute(@PathVariable Long id) {
		routeService.deleteRoute(id);
	}

	@Operation(summary = "Assign route to vehicle")
	@PostMapping("/assign")
	public Route assignRoute(@RequestBody Route route) {

		return routeService.assignRoute(route);
	}
}