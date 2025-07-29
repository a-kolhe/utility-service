package com.working.utility_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AliveController {

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
}
