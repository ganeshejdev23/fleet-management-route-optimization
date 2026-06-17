package com.fleet.fleet_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleet.fleet_management.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}