package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.print.Printable;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import com.example.demo.Dao.StaffDao;
import com.example.demo.Dto.Staff;

@SpringBootTest
@AutoConfigureMockMvc
public class StaffDaoTest {
	@Autowired
	private StaffDao staffDao;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getById(){
		List<Staff> Stafflist = staffDao.findById(1);
	assertNotNull(Stafflist);
	assertNotNull(Stafflist.getClass());
	assertEquals("Class",Stafflist.getClass());
	}
	
	@Test
	public void searchProduct() throws Exception{
		MvcResult mvcResult =mockMvc.perform(MockMvcRequestBuilders.get("/staffs/read"))
		.andExpect(MockMvcResultMatchers.status().is(200))
		.andReturn();
		String body = mvcResult.getResponse().getContentAsString();
		System.out.println("response body:"+body);
		}
	
	@Test
	public void createProduct() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + " \"name\":\"冰沙\",\n" + " \"price\":149\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().is(201));
	}


}
