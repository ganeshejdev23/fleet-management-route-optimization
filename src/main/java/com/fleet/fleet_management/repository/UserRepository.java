package com.fleet.fleet_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleet.fleet_management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}