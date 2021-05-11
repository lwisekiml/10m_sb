package com.example.demo;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Company> getAll() {
		List<Company> companyList = companyMapper.getAll();
		if(companyList != null && companyList.size() > 0) {
			for (Company company : companyList) {
				company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
			}
		}
		return companyList;
	}
	
//	@Transactional // runtime exception 발생시 롤백(@Transactional이 없으면 롭백안되고 적용됨)
	@Transactional(rollbackFor = Exception.class) // Exception 을 상속받은 모든 것
	public Company add(Company company) throws Exception {
		companyMapper.insert(company);
		// add company into legacy system
		if (true) {
			throw new RuntimeException("Legacy Exception");
		}
		return company;
	}
}
