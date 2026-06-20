package com.fleet.fleet_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleet_management.entity.Vehicle;
import com.fleet.fleet_management.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {

		this.vehicleService = vehicleService;
	}

	@PostMapping
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {

		return vehicleService.saveVehicle(vehicle);
	}

	@GetMapping
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable Long id) {

		return vehicleService.getVehicleById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteVehicle(@PathVariable Long id) {

		vehicleService.deleteVehicle(id);
	}
}