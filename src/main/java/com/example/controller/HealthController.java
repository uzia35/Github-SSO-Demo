package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the home page.
 */
@RestController
public class HealthController {

	@GetMapping("/health")
	@PreAuthorize(value = "isAuthenticated()")
	public ResponseEntity<String> health() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return new ResponseEntity<>("user is logged in as: " + auth.getPrincipal().toString(), HttpStatus.OK);
	}
	
	@GetMapping("/healthOpen")
	public ResponseEntity<String> healthOpen() {
		return new ResponseEntity<>("UP", HttpStatus.OK);
	}
}