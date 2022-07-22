package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Dto.Staff;

public class StaffRowMapper implements RowMapper<Staff> {
	@Override
	public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
		Staff staff = new Staff();
		staff.setId(rs.getInt("id"));
		staff.setName(rs.getString("name"));
		staff.setAccount(rs.getString("account"));
		return staff;
	}
	
}
