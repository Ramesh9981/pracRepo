package com.spring.qa.prac;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.qa.prac.service.Car;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class PracApplication  extends SpringBootServletInitializer  {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PracApplication.class);
    }

	public static void main(String[] args) {
		
		// ConfigurableApplicationContext context =
		SpringApplication.run(PracApplication.class, args);

		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("ApplicationContext.xml");

		// Car car = context.getBean(Car.class);
		// System.out.println(car.getEngineName());
		
		String name = "ramesh";
		String name2 = "ramesh"; 
		
        int num =100;
		
		String name1 = new String("Ramesh Babu"); 
		String name3 = new String("Ramesh Babu"); 
		
		System.out.println(name == name2);
		
		System.out.println(name1 == name3);
		System.out.println(name1.equalsIgnoreCase(name3));
	}

}
