package com.fleet.fleet_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fleet.fleet_management.entity.Driver;
import com.fleet.fleet_management.repository.DriverRepository;

@Service
public class DriverService {

	private final DriverRepository driverRepository;

	public DriverService(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	public Driver saveDriver(Driver driver) {
		return driverRepository.save(driver);
	}

	public List<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}

	public Driver getDriverById(Long id) {
		return driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));
	}

	public void deleteDriver(Long id) {
		driverRepository.deleteById(id);
	}

	public Driver updateDriver(Long id, Driver updatedDriver) {

		Driver driver = driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));

		driver.setName(updatedDriver.getName());
		driver.setLicenseNumber(updatedDriver.getLicenseNumber());
		driver.setPhone(updatedDriver.getPhone());
		driver.setShiftHours(updatedDriver.getShiftHours());
		driver.setStatus(updatedDriver.getStatus());

		return driverRepository.save(driver);
	}
}