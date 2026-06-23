package com.fleet.fleet_management.dto;

import java.util.List;

public class OptimizedRouteResponseDto {

	private List<String> optimizedRoute;

	public OptimizedRouteResponseDto() {
	}

	public OptimizedRouteResponseDto(List<String> optimizedRoute) {

		this.optimizedRoute = optimizedRoute;
	}

	public List<String> getOptimizedRoute() {
		return optimizedRoute;
	}

	public void setOptimizedRoute(List<String> optimizedRoute) {

		this.optimizedRoute = optimizedRoute;
	}
}