package com.fleet.fleet_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fleet.fleet_management.entity.Route;
import com.fleet.fleet_management.repository.RouteRepository;

@Service
public class RouteService {

	private final RouteRepository routeRepository;

	public RouteService(RouteRepository routeRepository) {

		this.routeRepository = routeRepository;
	}

	public Route saveRoute(Route route) {
		return routeRepository.save(route);
	}

	public List<Route> getAllRoutes() {
		return routeRepository.findAll();
	}

	public Route getRouteById(Long id) {
		return routeRepository.findById(id).orElse(null);
	}

	public void deleteRoute(Long id) {
		routeRepository.deleteById(id);
	}
}