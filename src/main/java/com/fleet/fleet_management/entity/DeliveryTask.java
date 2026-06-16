package com.fleet.fleet_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_tasks")
public class DeliveryTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pickupLocation;

	private String dropLocation;

	private String priority;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle assignedVehicle;

	public DeliveryTask() {
	}

	public DeliveryTask(Long id, String pickupLocation, String dropLocation, String priority,
			DeliveryStatus deliveryStatus, Vehicle assignedVehicle) {

		this.id = id;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.priority = priority;
		this.deliveryStatus = deliveryStatus;
		this.assignedVehicle = assignedVehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {

		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {

		this.dropLocation = dropLocation;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {

		this.priority = priority;
	}

	public DeliveryStatus getDeliveryStatus() {

		return deliveryStatus;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {

		this.deliveryStatus = deliveryStatus;
	}

	public Vehicle getAssignedVehicle() {

		return assignedVehicle;
	}

	public void setAssignedVehicle(Vehicle assignedVehicle) {

		this.assignedVehicle = assignedVehicle;
	}
}