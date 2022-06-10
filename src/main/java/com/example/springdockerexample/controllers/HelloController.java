package com.example.springdockerexample.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public ResponseEntity<String> greeting() {
		return ResponseEntity.ok("Hola mundo! Luisma y Ginasia");
	}
}