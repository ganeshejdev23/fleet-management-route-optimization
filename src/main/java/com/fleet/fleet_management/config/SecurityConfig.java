package com.fleet.fleet_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import com.fleet.fleet_management.security.JwtFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	private final JwtFilter jwtFilter;

	public SecurityConfig(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				// Since we are using JWT, no HTTP session is needed
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.authorizeHttpRequests(auth -> auth

						// Public APIs
						.requestMatchers("/auth/**", "/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**")
						.permitAll()

						// ADMIN only
						.requestMatchers("/users/**").hasRole("ADMIN")

						// ADMIN & DISPATCHER
						.requestMatchers("/vehicles/**", "/routes/**", "/delivery-tasks/**")
						.hasAnyRole("ADMIN", "DISPATCHER")

						// ADMIN, DISPATCHER & DRIVER
						.requestMatchers("/drivers/**").hasAnyRole("ADMIN", "DISPATCHER", "DRIVER")

						.anyRequest().authenticated())

				// Add JWT filter before Spring's authentication filter
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

		return configuration.getAuthenticationManager();
	}

}