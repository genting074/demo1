package com.example.demo.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSourceConfig {
	//連線到 demo1
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.demo1")
	public DataSource demo1DataSource(){
	return DataSourceBuilder.create().build();
	}
	@Bean
	public NamedParameterJdbcTemplate demo1JdbcTemplate(@Qualifier("demo1DataSource") DataSource dataSource){
	return new NamedParameterJdbcTemplate(dataSource);
	}
//	//連線到 demo2
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.demo2")
//	public DataSource demo2DataSource(){
//	return DataSourceBuilder.create().build();
//	}
//	@Bean
//	public NamedParameterJdbcTemplate demo2JdbcTemplate(@Qualifier("demo2DataSource") DataSource dataSource){
//	return new NamedParameterJdbcTemplate(dataSource);
//	}
	}

