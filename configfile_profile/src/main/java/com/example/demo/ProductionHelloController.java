package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("production")
public class ProductionHelloController {
	
	@Value("${hello.message}") // application.properties에 있는 값
	private String helloMessage;
	
	@Value("${hello}")
	private String hello; // 한글은 아스키코드로 해야 함(https://native2ascii.net/)
	
	@Value("${hello.messageee: 반갑습니다.}") // application.properties에 값이 없을 경우 디폴트 값 설정
	private String helloee;
	
	@Value("${hello.countries}")
	private List<String> countries;
	
	@Value("#{${hello.account}}") // #{}를 해주어 Map으로 가져오게 한다.
	private Map<String, String> accountMap;
	
	@GetMapping("/hello")
	public String getHello() {
		return "[ProductionHelloController]" + helloMessage + "\n" + hello + "\n" + helloee + countries;
	}
	
//	@GetMapping("/country")
//	public String getCountries() {
//		return countries; // 단독으로 쓸 수 없는것 같다.
//	}
	
	@GetMapping("/account")
	public String getAccount() {
		return accountMap.get("name") + " " + accountMap.get("password");
	}
}
