package com.fleet.fleet_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fleet.fleet_management.entity.DeliveryTask;
import com.fleet.fleet_management.repository.DeliveryTaskRepository;

@Service
public class DeliveryTaskService {

	private final DeliveryTaskRepository repository;

	public DeliveryTaskService(DeliveryTaskRepository repository) {

		this.repository = repository;
	}

	public DeliveryTask saveTask(DeliveryTask task) {

		return repository.save(task);
	}

	public List<DeliveryTask> getAllTasks() {
		return repository.findAll();
	}

	public DeliveryTask getTaskById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteTask(Long id) {
		repository.deleteById(id);
	}
}