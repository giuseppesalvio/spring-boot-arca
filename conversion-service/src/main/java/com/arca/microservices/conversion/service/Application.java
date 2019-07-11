package com.arca.microservices.conversion.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = Application.class)
@EnableDiscoveryClient
@EnableRetry
@Import(RibbonAutoConfiguration.class)
public
class Application
{
	public static
	void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
