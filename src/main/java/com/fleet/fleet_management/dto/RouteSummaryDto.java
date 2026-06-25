package com.fleet.fleet_management.dto;

import java.util.List;

public class RouteSummaryDto {

	private List<String> optimizedRoute;
	private int totalStops;
	private String startingPoint;
	private String endingPoint;

	public RouteSummaryDto() {
	}

	public RouteSummaryDto(List<String> optimizedRoute, int totalStops, String startingPoint, String endingPoint) {
		this.optimizedRoute = optimizedRoute;
		this.totalStops = totalStops;
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
	}

	public List<String> getOptimizedRoute() {
		return optimizedRoute;
	}

	public void setOptimizedRoute(List<String> optimizedRoute) {
		this.optimizedRoute = optimizedRoute;
	}

	public int getTotalStops() {
		return totalStops;
	}

	public void setTotalStops(int totalStops) {
		this.totalStops = totalStops;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getEndingPoint() {
		return endingPoint;
	}

	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}
}