package com.fleet.fleet_management.dto;

import java.util.List;

public class RouteRequestDto {

	private List<String> locations;

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
}