package com.fleet.fleet_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleet_management.dto.ManifestResponse;
import com.fleet.fleet_management.entity.DeliveryTask;
import com.fleet.fleet_management.service.DeliveryTaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Delivery Task Management", description = "APIs for delivery tasks")
@RestController
@RequestMapping("/tasks")
public class DeliveryTaskController {

	private final DeliveryTaskService service;

	public DeliveryTaskController(DeliveryTaskService service) {

		this.service = service;
	}

	@Operation(summary = "Create delivery task")
	@PostMapping
	public DeliveryTask createTask(@Valid @RequestBody DeliveryTask task) {

		return service.saveTask(task);
	}

	@Operation(summary = "Get all delivery tasks")
	@GetMapping
	public List<DeliveryTask> getAllTasks() {
		return service.getAllTasks();
	}

	@Operation(summary = "Get delivery task by ID")
	@GetMapping("/{id}")
	public DeliveryTask getTaskById(@PathVariable Long id) {

		return service.getTaskById(id);
	}

	@Operation(summary = "Generate delivery manifest")
	@GetMapping("/manifest/{id}")
	public ManifestResponse generateManifest(@PathVariable Long id) {

		return service.generateManifest(id);
	}

	@Operation(summary = "Delete delivery task")
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {

		service.deleteTask(id);
	}

	// Dispatch API
	@Operation(summary = "Dispatch delivery task")
	@PutMapping("/dispatch/{id}")
	public DeliveryTask dispatchTask(@PathVariable Long id) {

		return service.dispatchTask(id);
	}

	// In Transit API
	@Operation(summary = "Mark delivery as In Transit")
	@PutMapping("/in-transit/{id}")
	public DeliveryTask markInTransit(@PathVariable Long id) {

		return service.markInTransit(id);
	}

	// Delivered API
	@Operation(summary = "Mark delivery as Delivered")
	@PutMapping("/deliver/{id}")
	public DeliveryTask markDelivered(@PathVariable Long id) {

		return service.markDelivered(id);
	}
}