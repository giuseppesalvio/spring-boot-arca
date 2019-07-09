package com.arca.microservices.http.session;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.session.JdbcSessionDataSourceInitializer;
import org.springframework.boot.autoconfigure.session.JdbcSessionProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public
class SpringSessionDataSourceConfiguration
{
	@Bean
	@ConfigurationProperties("spring.session.datasource")
	public
	DataSourceProperties springSessionDataSourceProperties()
	{
		return new DataSourceProperties();
	}

	@Bean
	@SpringSessionDataSource
	public
	DataSource springSessionDataSource()
	{
		return springSessionDataSourceProperties().initializeDataSourceBuilder()
		                                          .build();
	}

	@Bean
	public
	PlatformTransactionManager springSessionTransactionManager()
	{
		return new DataSourceTransactionManager(springSessionDataSource());
	}

	@Bean
	public
	JdbcSessionDataSourceInitializer jdbcSessionDataSourceInitializer(ResourceLoader resourceLoader,
	                                                                  JdbcSessionProperties properties)
	{
		return new JdbcSessionDataSourceInitializer(springSessionDataSource(), resourceLoader, properties);
	}

	@Bean
	public
	JdbcTemplate springSessionJdbcOperations()
	{
		return new JdbcTemplate(springSessionDataSource());
	}
}
