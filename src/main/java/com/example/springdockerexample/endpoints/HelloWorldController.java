package org.springbootdocker.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(value = "/")
	public ResponseEntity<String> greeting() {
		return ResponseEntity.ok("Hola mundo! Luisma");
	}

}
