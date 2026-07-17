package com.fleet.fleet_management.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fleet.fleet_management.dto.LoginRequestDto;
import com.fleet.fleet_management.dto.LoginResponseDto;
import com.fleet.fleet_management.dto.RegisterRequestDto;
import com.fleet.fleet_management.entity.User;
import com.fleet.fleet_management.repository.UserRepository;
import com.fleet.fleet_management.security.JwtUtil;

@Service
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;

	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
			AuthenticationManager authenticationManager) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}

	public String register(RegisterRequestDto request) {

		if (userRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new RuntimeException("Username already exists");
		}

		User user = new User();

		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());

		userRepository.save(user);

		return "User Registered Successfully";
	}

	public LoginResponseDto login(LoginRequestDto request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		String token = jwtUtil.generateToken(request.getUsername());

		return new LoginResponseDto(token);
	}
}