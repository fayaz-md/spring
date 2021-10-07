package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages="com")
@EntityScan(basePackages="com.bean")
public class DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DemoApp.class, args);
		System.out.println("Server running");
	}

}
