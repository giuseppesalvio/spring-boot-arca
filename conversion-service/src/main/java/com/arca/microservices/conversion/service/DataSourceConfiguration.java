package com.arca.microservices.conversion.service;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public
class DataSourceConfiguration
{
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public
	DataSourceProperties primaryDataSourceProperties()
	{
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.configuration")
	public
	HikariDataSource primaryDataSource()
	{
		return primaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

//	@Bean
//	@Primary
//	public
//	PlatformTransactionManager primaryTransactionManager()
//	{
//		return new DataSourceTransactionManager(primaryDataSource());
//	}
}
