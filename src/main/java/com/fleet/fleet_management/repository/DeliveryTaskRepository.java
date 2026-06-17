package com.fleet.fleet_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleet.fleet_management.entity.DeliveryTask;

public interface DeliveryTaskRepository extends JpaRepository<DeliveryTask, Long> {
}