package com.arca.microservices.conversion.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = Application.class)
@EnableDiscoveryClient
public
class Application
{
	public static
	void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
