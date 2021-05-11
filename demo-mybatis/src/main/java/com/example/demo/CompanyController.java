package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyService companyService;
	
//	@PostMapping
//	public int post(@RequestBody Company company) { // RequestBody로 해서 postman에서 JSON으로 전송을 해야함
//		return companyMapper.insert(company); // 입력 성공 : 1, 실패 : 0
//	}

	@PostMapping
	public Company post(@RequestBody Company company) { // RequestBody로 해서 postman에서 JSON으로 전송을 해야함
//		companyMapper.insert(company);
		companyService.add(company);
		return company; // 전체 정보 반환
	}
	
	@GetMapping("")
	public List<Company> getAll() {
		return companyMapper.getAll();
	}

//	@GetMapping("")
//	public List<Company> getAll() {
//		return companyService.getAll();
//	}

	@GetMapping("/{id}")
	public Company getById(@PathVariable("id") int id) {
		return companyMapper.getById(id);
	}
}
