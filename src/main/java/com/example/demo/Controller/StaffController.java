package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StaffRowMapper;
import com.example.demo.Dto.Staff;
import com.example.demo.Service.StaffService;

@RestController
public class StaffController {
	
	private final static Logger logger = LoggerFactory.getLogger(StaffController.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private StaffService staffService;

	@PostMapping("/staff/create")
	public String create(@RequestBody Staff staff) {

		staffService.insert(staff);
		logger.info("staff action create!{}",staff.getId());
		return "staff action create!";
	}

	@PostMapping("/staff/delete/{id}")
	public String delete(@PathVariable Integer id) {

		return staffService.deleteById(id);
	}

	@PostMapping("/staff/batchcreate")
	public String batchcreate(@RequestBody List<Staff> staffs) {
		String sql = "insert into staff(name,account) values(:name,:account)";
		MapSqlParameterSource[] sqlParameterSources = new MapSqlParameterSource[staffs.size()];
		for (int i = 0; i < staffs.size(); i++) {
			Staff staff = staffs.get(i);
			sqlParameterSources[i] = new MapSqlParameterSource();
			sqlParameterSources[i].addValue("name", staff.getName());
			sqlParameterSources[i].addValue("account", staff.getAccount());
		}

		namedParameterJdbcTemplate.batchUpdate(sql, sqlParameterSources);

		return "staff action create!";
	}

	@GetMapping("/staffs/read")
	public List<Staff> read() {
		String sql = "select id,name,account from staff";
		Map<String, Object> map = new HashMap<>();
		return namedParameterJdbcTemplate.query(sql, map, new BeanPropertyRowMapper<>(Staff.class));
	}

	@GetMapping("/staffs/getStaff")
	public String getStaff(@RequestParam Integer id) {
		staffService.findById(id);
		return "getStaff:";

	}
}
