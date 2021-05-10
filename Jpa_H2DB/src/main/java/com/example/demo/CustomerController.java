package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Customer;

@RestController
public class CustomerController {
	
	private CustomerRepository repository;

	public CustomerController(CustomerRepository repository) {
		super();
		this.repository = repository;
	}
	
	@PostMapping("/customer")
	public Customer postCustomer(Customer customer) {
		return repository.save(customer);
	}

	@PutMapping("/customer")
	public Customer putCustomer(Customer customer) {
		return repository.save(customer);
	}
	
	@DeleteMapping("/customer") // 없는 데이터 삭제시도 시 500 error
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/customer")
	public Customer getCustomer(int id) {
//		return repository.findById(id).orElse(null); // 없는 데이터의 경우 200 OK (null이 넘어오므로)
		return repository.findById(id).orElseThrow(); // 없는 데티어 시 500 error
	}
	
	@GetMapping("/customer/name")
	public List<Customer> getCustomer(String name) {
		return repository.findByName(name);
	}
	
	@GetMapping("/customer/search")
	public List<Customer> searchCustomer(String name) {
		return repository.findByNameLike("%" + name + "%"); // 이름 부분검색(Like)
	}

	@GetMapping("/customer/if")
	public List<Customer> getCustomerIf(String name, String address) {
		return repository.findVipList2(name, address);
	}

	@GetMapping("/customer/address")
	public List<Customer> getCustomerAddress(String address) {
		return repository.findByAddress(address);
	}
	
	@GetMapping("/customer/list")
	public List<Customer> getCustomerList() {
		return (List<Customer>)repository.findAll();
	}
}