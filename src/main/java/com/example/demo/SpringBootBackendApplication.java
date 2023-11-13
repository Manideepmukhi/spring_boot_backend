package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.repository.EmployeeRepository;


@SpringBootApplication
public class SpringBootBackendApplication {
	   
	   
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApplication.class, args);
		
		 
	}
	 

}
