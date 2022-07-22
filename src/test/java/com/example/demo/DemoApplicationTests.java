package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.demo.Dto.ProductEntity;
import com.example.demo.Dto.Staff;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class DemoApplicationTests {

	@ConfigurationProperties(prefix = "spring.datasource3")
	public DataSource demo3DataSource(){
	return DataSourceBuilder.create().build();
	}
	private NamedParameterJdbcTemplate demo1JdbcTemplate;
	
	void contextLoads() {

		String sql = "select * from PRODUCT ";
		Map<String, Object> map = new HashMap<>();
		List<Staff> list = demo1JdbcTemplate.query(sql, map, new StaffRowMapper());
	}

	@Test
	public void convertToString() throws JsonProcessingException {
		Staff staff = new Staff();
		staff.setId(1);
		staff.setName("Car");
		staff.setAccount("123456");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResult = objectMapper.writeValueAsString(staff);
		System.out.println("json value:" + jsonResult);
	}
}
