package com.fleet.fleet_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fleet.fleet_management.dto.LocationDto;
import com.fleet.fleet_management.dto.RouteSummaryDto;

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

	public List<String> optimizeNearestRoute() {

		List<LocationDto> cities = new ArrayList<>();

		cities.add(new LocationDto("Hyderabad", 17.3850, 78.4867));

		cities.add(new LocationDto("Pune", 18.5204, 73.8567));

		cities.add(new LocationDto("Bangalore", 12.9716, 77.5946));

		cities.add(new LocationDto("Chennai", 13.0827, 80.2707));

		List<String> route = new ArrayList<>();

		LocationDto current = cities.remove(0);

		route.add(current.getCity());

		while (!cities.isEmpty()) {

			LocationDto nearest = null;

			double shortestDistance = Double.MAX_VALUE;

			for (LocationDto city : cities) {

				double distance = calculateDistance(current, city);

				if (distance < shortestDistance) {

					shortestDistance = distance;

					nearest = city;
				}
			}

			route.add(nearest.getCity());

			cities.remove(nearest);

			current = nearest;
		}

		return route;
	}

	private double calculateDistance(LocationDto a, LocationDto b) {

		double lat = a.getLatitude() - b.getLatitude();

		double lon = a.getLongitude() - b.getLongitude();

		return Math.sqrt(lat * lat + lon * lon);
	}

	public RouteSummaryDto generateRouteSummary() {

		List<String> route = optimizeNearestRoute();

		return new RouteSummaryDto(route, route.size(), route.get(0), route.get(route.size() - 1));
	}
}