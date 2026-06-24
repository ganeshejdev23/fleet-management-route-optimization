package com.fleet.fleet_management.dto;

public class LocationDto {

	private String city;
	private double latitude;
	private double longitude;

	public LocationDto() {
	}

	public LocationDto(String city, double latitude, double longitude) {

		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}