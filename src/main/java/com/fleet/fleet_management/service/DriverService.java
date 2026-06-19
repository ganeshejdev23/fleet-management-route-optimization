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
		return driverRepository.findById(id).orElse(null);
	}

	public void deleteDriver(Long id) {
		driverRepository.deleteById(id);
	}
}