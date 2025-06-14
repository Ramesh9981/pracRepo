package com.spring.qa.prac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	Engine engine;

	public String getEngineName() {
		return engine.name;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine; 
	}

//	public Car(Engine engine) {
//		this.engine = engine;
//	}

}
