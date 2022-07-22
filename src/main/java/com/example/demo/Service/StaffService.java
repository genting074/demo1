package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Dao.StaffDao;
import com.example.demo.Dto.Staff;

@Service
public class StaffService {
	@Autowired
	private StaffDao dao;
	
	public void insert(Staff staff){
	   dao.insert(staff);
	}
	public List<Staff> findById( Integer id){
		return dao.findById(id);
	};
	public String deleteById( Integer id){
		return dao.deleteById(id);
	};

}
