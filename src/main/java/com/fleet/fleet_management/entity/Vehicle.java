package com.fleet.fleet_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String vehicleNumber;

	private double capacity;

	private String maintenanceStatus;

	private String vehicleType;

	@OneToOne
	@JoinColumn(name = "driver_id")
	private Driver assignedDriver;

	public Vehicle() {
	}

	public Vehicle(Long id, String vehicleNumber, double capacity, String maintenanceStatus, String vehicleType,
			Driver assignedDriver) {

		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.capacity = capacity;
		this.maintenanceStatus = maintenanceStatus;
		this.vehicleType = vehicleType;
		this.assignedDriver = assignedDriver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {

		this.vehicleNumber = vehicleNumber;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {

		this.capacity = capacity;
	}

	public String getMaintenanceStatus() {
		return maintenanceStatus;
	}

	public void setMaintenanceStatus(String maintenanceStatus) {

		this.maintenanceStatus = maintenanceStatus;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {

		this.vehicleType = vehicleType;
	}

	public Driver getAssignedDriver() {
		return assignedDriver;
	}

	public void setAssignedDriver(Driver assignedDriver) {

		this.assignedDriver = assignedDriver;
	}
}