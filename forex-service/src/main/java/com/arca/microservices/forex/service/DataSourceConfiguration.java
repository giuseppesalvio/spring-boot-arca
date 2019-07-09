package com.arca.microservices.forex.service;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public
class DataSourceConfiguration
{
	@Bean
	@Primary
	@ConfigurationProperties("spring.primary.datasource")
	public
	DataSourceProperties primaryDataSourceProperties()
	{
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	public
	DataSource primaryDataSource()
	{
		return primaryDataSourceProperties().initializeDataSourceBuilder()
		                                    .build();
	}

	@Bean
	@Primary
	public
	PlatformTransactionManager transactionManager()
	{
		return new DataSourceTransactionManager(primaryDataSource());
	}
}
