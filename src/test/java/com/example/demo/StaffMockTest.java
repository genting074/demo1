package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Dao.StaffDao;
import com.example.demo.Dto.Staff;
import com.example.demo.Service.StaffService;

@SpringBootTest
public class StaffMockTest {
	@Autowired
	private StaffService staffSerivce;
	@MockBean
	private StaffDao staffDao;

	@SuppressWarnings("unchecked")
	
	public void findById() {
		// given
		Staff mockProduct = new Staff();
		mockProduct.setId(100);
		mockProduct.setName("機⾞");
		// when
		Mockito.when(staffDao.findById(3)).thenReturn((List<Staff>) mockProduct);
		List<Staff> staff = staffSerivce.findById(3);
		// then
		assertNotNull(staff);
		assertEquals("NoteBook", staff.getClass());
	}
	
	public void findProduct() {
		// given
		Staff mockProduct = new Staff();
		mockProduct.setId(100);
		mockProduct.setName("機⾞");
		// when
		Mockito.when(staffDao.findById(3)).thenReturn((List<Staff>) mockProduct);
		List<Staff> staff = staffSerivce.findById(3);
		// then
		assertNotNull(staff);
		assertEquals("NoteBook", staff.getClass());
	}
}
