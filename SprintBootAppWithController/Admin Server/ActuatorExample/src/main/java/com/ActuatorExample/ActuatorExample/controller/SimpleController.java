package com.ActuatorExample.ActuatorExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@GetMapping
	public String hello() {
		return "hello";
	}
}
