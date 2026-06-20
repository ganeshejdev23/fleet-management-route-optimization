package com.fleet.fleet_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleet_management.entity.Driver;
import com.fleet.fleet_management.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	private final DriverService driverService;

	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}

	@PostMapping
	public Driver createDriver(@RequestBody Driver driver) {

		return driverService.saveDriver(driver);
	}

	@GetMapping
	public List<Driver> getAllDrivers() {
		return driverService.getAllDrivers();
	}

	@GetMapping("/{id}")
	public Driver getDriverById(@PathVariable Long id) {

		return driverService.getDriverById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteDriver(@PathVariable Long id) {

		driverService.deleteDriver(id);
	}
}