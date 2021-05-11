package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CompanyMapper {
	
	@Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("company") Company company); // 입력 성공 : 1, 실패 : 0
	
	@Select("SELECT * FROM company")
	// @Result는 company_name을 name으로 매칭
	@Results({
		@Result(property = "name", column = "company_name"),
		@Result(property = "address", column = "company_address")
	})
	List<Company> getAll();
}
