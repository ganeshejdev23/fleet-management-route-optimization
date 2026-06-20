package com.fleet.fleet_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.fleet_management.entity.DeliveryTask;
import com.fleet.fleet_management.service.DeliveryTaskService;

@RestController
@RequestMapping("/tasks")
public class DeliveryTaskController {

	private final DeliveryTaskService service;

	public DeliveryTaskController(DeliveryTaskService service) {

		this.service = service;
	}

	@PostMapping
	public DeliveryTask createTask(@RequestBody DeliveryTask task) {

		return service.saveTask(task);
	}

	@GetMapping
	public List<DeliveryTask> getAllTasks() {
		return service.getAllTasks();
	}

	@GetMapping("/{id}")
	public DeliveryTask getTaskById(@PathVariable Long id) {

		return service.getTaskById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {

		service.deleteTask(id);
	}
}