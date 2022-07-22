package com.example.demo.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.StaffRowMapper;
import com.example.demo.Dto.Staff;

@Component
public class StaffDao {
	@Autowired
	@Qualifier("demo1JdbcTemplate")
	private NamedParameterJdbcTemplate demo1JdbcTemplate;
//	@Autowired
//	@Qualifier("demo2JdbcTemplate")
//	private NamedParameterJdbcTemplate demo2JdbcTemplate;

	
	public void insert(@RequestBody Staff staff) {
		String sql ="insert into staff(name,account) values(:name,:account)";
		Map<String, Object> map = new HashMap<>();
		map.put("name", staff.getName());
		map.put("account", staff.getAccount());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		demo1JdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
		int id = keyHolder.getKey().intValue();
		System.out.println("auto_increment id:"+id);	
		
	}
	
	public List<Staff> findById(@RequestParam Integer id){
		boolean code = false;
		String sql = "select * from staff where id = :id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		List<Staff> list = demo1JdbcTemplate.query(sql, map, new StaffRowMapper());
		if (list.size() > 0) {
			System.out.println(list.get(0).getName());
			code = true;
		}
		
		return list;
	}

	public String deleteById(@RequestParam Integer id){
		String sql = "delete from staff where id = :id";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		demo1JdbcTemplate.update(sql, map);
		
		return "deleteById:"+id.toString();
	}
	
	
}
