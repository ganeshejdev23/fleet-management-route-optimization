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

@RestController
@RequestMapping("/routes")
public class RouteController {

	private final RouteService routeService;

	public RouteController(RouteService routeService) {

		this.routeService = routeService;
	}

	@PostMapping
	public Route createRoute(@RequestBody Route route) {

		return routeService.saveRoute(route);
	}

	@GetMapping
	public List<Route> getAllRoutes() {
		return routeService.getAllRoutes();
	}

	@GetMapping("/{id}")
	public Route getRouteById(@PathVariable Long id) {

		return routeService.getRouteById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteRoute(@PathVariable Long id) {

		routeService.deleteRoute(id);
	}
}