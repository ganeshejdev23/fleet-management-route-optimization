package com.fleet.fleet_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fleet.fleet_management.dto.ManifestResponse;
import com.fleet.fleet_management.entity.DeliveryStatus;
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

	// Dispatch Task
	public DeliveryTask dispatchTask(Long id) {

		DeliveryTask task = repository.findById(id).orElse(null);

		if (task != null) {

			task.setDeliveryStatus(DeliveryStatus.DISPATCHED);

			return repository.save(task);
		}

		return null;
	}

	// Mark In Transit

	public DeliveryTask markInTransit(Long id) {

		DeliveryTask task = repository.findById(id).orElse(null);

		if (task != null) {

			task.setDeliveryStatus(DeliveryStatus.IN_TRANSIT);

			return repository.save(task);
		}

		return null;
	}

	// Mark Delivered

	public DeliveryTask markDelivered(Long id) {

		DeliveryTask task = repository.findById(id).orElse(null);

		if (task != null) {

			task.setDeliveryStatus(DeliveryStatus.DELIVERED);

			return repository.save(task);
		}

		return null;
	}

	public ManifestResponse generateManifest(Long id) {

		DeliveryTask task = repository.findById(id).orElse(null);

		if (task == null) {
			return null;
		}

		ManifestResponse response = new ManifestResponse();

		response.setTaskId(task.getId());
		response.setPickupLocation(task.getPickupLocation());
		response.setDropLocation(task.getDropLocation());
		response.setPriority(task.getPriority());
		response.setDeliveryStatus(task.getDeliveryStatus().name());

		if (task.getAssignedVehicle() != null) {

			response.setVehicleNumber(task.getAssignedVehicle().getVehicleNumber());

			response.setVehicleCapacity(task.getAssignedVehicle().getCapacity());

			if (task.getAssignedVehicle().getAssignedDriver() != null) {

				response.setDriverName(task.getAssignedVehicle().getAssignedDriver().getName());
			}
		}

		return response;
	}
}
