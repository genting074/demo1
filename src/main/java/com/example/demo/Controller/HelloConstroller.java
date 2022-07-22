package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TestComponent;
import com.example.demo.TestInertface;
import com.example.demo.Dto.Skill;
import com.example.demo.Dto.Student;

@RestController	
@RequestMapping("/hello")
public class HelloConstroller {
	@Value("${company.name}")
	private String name;

	@Autowired
	private TestComponent testcomponent;
	@Autowired
	@Qualifier("showComponent")
	private TestInertface testinertface;
//	@Qualifier("showComponent")
//	private MyConfig myconfig;
	
	@RequestMapping("/search")
	public String search() {
		testinertface.show();
		return "Hello!!"+name;
		
	}

	@RequestMapping("/student")	
	public List<Student> searchStudent(@RequestParam(defaultValue = "0") Integer id) {
		
		ArrayList<Student> stdls = new ArrayList<Student>();
		Student std = new Student();
		
		std.setId(id);
		std.setName("七七七");
		std.setWeight(70.0);
		
		ArrayList<String> ls = new ArrayList<String>();
		ls.add("紅色");
		ls.add("汽車");
		std.setHaveCar(true);
		std.setCarType(ls);
		
		Skill sk = new Skill();
		sk.setName("數學");
		sk.setYear(5);
		std.setSkill(sk);
		stdls.add(std);
		
		return stdls;
	}
	
	@RequestMapping("/poststudent")	
	public List<Student> postStudent(@RequestBody Student student) {
		
		ArrayList<Student> stdls = new ArrayList<Student>();
		stdls.add(student);
		
		return stdls;
	}
	

	@RequestMapping("/search/{id}")	
	public String getSearch(@PathVariable Integer id) {
				
		return "Hello id:"+id;
	}
	
}
