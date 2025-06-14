package com.spring.qa.prac.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${server.port}")
	private String portNumber;

	@GetMapping("/codingQa")
	public void pracQAtesting() {
		System.out.println(" Port Number application is running :"+ portNumber);
	}
}
