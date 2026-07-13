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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Vehicle Management", description = "APIs for managing vehicles")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	private final VehicleService vehicleService;

	public VehicleController(VehicleService vehicleService) {

		this.vehicleService = vehicleService;
	}

	@Operation(summary = "Create a new vehicle")
	@PostMapping
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {

		return vehicleService.saveVehicle(vehicle);
	}

	@Operation(summary = "Get all vehicles")
	@GetMapping
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	@Operation(summary = "Get vehicle by ID")
	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable Long id) {

		return vehicleService.getVehicleById(id);
	}

	@Operation(summary = "Delete vehicle by ID")
	@DeleteMapping("/{id}")
	public void deleteVehicle(@PathVariable Long id) {

		vehicleService.deleteVehicle(id);
	}
}