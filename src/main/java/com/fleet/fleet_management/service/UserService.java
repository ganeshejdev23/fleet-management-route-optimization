package com.fleet.fleet_management.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fleet.fleet_management.entity.User;
import com.fleet.fleet_management.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	private final PasswordEncoder encoder;

	public UserService(UserRepository repository, PasswordEncoder encoder) {

		this.repository = repository;
		this.encoder = encoder;
	}

	public User register(User user) {

		user.setPassword(encoder.encode(user.getPassword()));

		return repository.save(user);
	}

}