package com.fleet.fleet_management.dto;

public class DispatcherSummaryDto {

	private String vehicle;

	private String route;

	private String status;

	public DispatcherSummaryDto() {
	}

	public DispatcherSummaryDto(String vehicle, String route, String status) {

		this.vehicle = vehicle;
		this.route = route;
		this.status = status;
	}

	public String getVehicle() {
		return vehicle;
	}

	public String getRoute() {
		return route;
	}

	public String getStatus() {
		return status;
	}
}