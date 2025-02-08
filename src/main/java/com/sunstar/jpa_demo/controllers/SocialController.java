package com.sunstar.jpa_demo.controllers;

import com.sunstar.jpa_demo.models.SocialUser;
import com.sunstar.jpa_demo.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
	@Autowired
	private SocialService socialService;

	@GetMapping("/social/users")
	public ResponseEntity<List<SocialUser>> getUsers() {
		return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
	}

	@PostMapping("/social/users")
	public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser) {
		return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.OK);
	}

	@DeleteMapping("/social/users/{userId}")
	public ResponseEntity<String> saveUser(@PathVariable Long userId) {
		socialService.deleteUser(userId);
		return new ResponseEntity<>("User deleted", HttpStatus.OK);
	}
}
