package com.fleet.fleet_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String licenseNumber;

	private String phone;

	private int shiftHours;

	private String status;

	public Driver() {
	}

	public Driver(Long id, String name, String licenseNumber, String phone, int shiftHours, String status) {

		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.phone = phone;
		this.shiftHours = shiftHours;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {

		this.licenseNumber = licenseNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getShiftHours() {
		return shiftHours;
	}

	public void setShiftHours(int shiftHours) {

		this.shiftHours = shiftHours;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}
}