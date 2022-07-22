package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Dto.Company;
import com.example.demo.Dto.ProductEntity;

@RestController
@RequestMapping("/hello")
public class CompanyController {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostMapping("/company")
	public String postcompany(@RequestBody Company company){
		System.out.println("postcompany");
	return "action post!";
	}
	
	@GetMapping("/company/{id}")
	public Company getcompany(@PathVariable Integer id){
		System.out.println("getcompany");
		Company cmp = new Company();
		cmp.setId(123);
		cmp.setName("AAA");
		cmp.setTel("0000-123456");
		cmp.setWorkers(10);
	return cmp;
	}


	@PutMapping("/company/{id}")
	public String putcompany(@PathVariable Integer id,	@RequestBody Company company){
		System.out.println("putcompany");
	return "action get!";
	}


	@DeleteMapping("/company/{id}")
	public String deletecompany(@PathVariable Integer id){
		System.out.println("deletecompany");
	return "action delete!";
	}

	
	@PostMapping("/company/create")
	public ResponseEntity<String> create(@RequestBody Company company){
		System.out.println("create");
	Map<String, Object> map = new HashMap<>();
	String sql = "insert into company(id,name) values (:id,:name)";
	map.put("id", company.getId());
	map.put("name", company.getName());
	namedParameterJdbcTemplate.update(sql, map);
	
	return ResponseEntity.status(HttpStatus.OK).body("action create!");
	}
	
	@PostMapping("/company/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		System.out.println("delete");
	Map<String, Object> map = new HashMap<>();
	String sql = "delete from company where id = :id";
	map.put("id", id);
	namedParameterJdbcTemplate.update(sql, map);
	
	return ResponseEntity.status(HttpStatus.OK).body("action delete!");
	}
	
	@GetMapping("/getToObject")
	public String getToObject(){
	RestTemplate restTemplate = new RestTemplate();
	ProductEntity result =
	restTemplate.getForObject("https://mocki.io/v1/b04d9cc2-24b1-44aa-881f-e1cb8b66233c",
	ProductEntity.class);
	System.out.println("Product id:"+result.getId());
	System.out.println("Product name:"+result.getName());
	System.out.println("Product price:"+result.getPrice());
	return "getToObject success";
	}
	
	@GetMapping("/getForObjectByMap")
	public String getForObjectByMap(){
	HashMap<String, Object> requestMap = new HashMap<>();
	requestMap.put("id",2);
	RestTemplate restTemplate = new RestTemplate();
	ProductEntity result = restTemplate.getForObject(
	"https://mocki.io/v1/b04d9cc2-24b1-44aa-881f-e1cb8b66233c",
	ProductEntity.class,
	requestMap);
	return "getForObjectByMap success";
	}

	@GetMapping("/getForEntity")
	public String getForEntity(){
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<ProductEntity> responseEntity =
	restTemplate.getForEntity("https://mocki.io/v1/b04d9cc2-24b1-44aa-881f-e1cb8b66233c",
	ProductEntity.class);
	System.out.println("status code:"+responseEntity.getStatusCode());
	ProductEntity result = responseEntity.getBody();
	System.out.println("Product id:"+result.getId());
	System.out.println("Product name:"+result.getName());
	System.out.println("Product price:"+result.getPrice());
	return "getForEntity success";
	}
}
