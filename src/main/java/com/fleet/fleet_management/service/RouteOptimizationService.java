package com.fleet.fleet_management.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RouteOptimizationService {

	private final RestTemplate restTemplate;

	public RouteOptimizationService(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	public String getRouteData(double startLon, double startLat, double endLon, double endLat) {

		String url = "https://router.project-osrm.org/route/v1/driving/" + startLon + "," + startLat + ";" + endLon
				+ "," + endLat + "?overview=false";

		return restTemplate.getForObject(url, String.class);
	}

	public List<String> optimizeRoute(List<String> locations) {

		List<String> optimized = new ArrayList<>(locations);

		optimized.sort(String::compareTo);

		return optimized;
	}
}