package com.fleet.fleet_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fleet.fleet_management.dto.LoginRequestDto;
import com.fleet.fleet_management.dto.LoginResponseDto;
import com.fleet.fleet_management.dto.RegisterRequestDto;
import com.fleet.fleet_management.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequestDto request) {

		return ResponseEntity.ok(authService.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {

		return ResponseEntity.ok(authService.login(request));
	}
}