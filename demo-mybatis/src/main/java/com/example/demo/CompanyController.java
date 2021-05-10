package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@PostMapping
	public int post(@RequestBody Company company) { // RequestBody로 해서 postman에서 JSON으로 전송을 해야함
		return companyMapper.insert(company);
	}
}
