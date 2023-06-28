package com.quantaGenious.spring.login;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={
"com.quantaGenious.spring"})
public class SpringBootLoginExampleApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginExampleApplication.class, args);
	}
	

}
