package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findByName(String name); // 이런식으로 만들면 알아서 name을 찾아 리턴해준다.
	List<Customer> findByAddress(String address);
	List<Customer> findByNameLike(String name); // 이름 부분검색(Like)
	List<Customer> findByNameOrAddress(String name, String address); // 이름 또는 주소로 검색
	List<Customer> findByNameLikeOrderByAddressDesc(String name);
	
//	@Query("from Customer where name = ?1 and address = ?2") // JPQL
	@Query("from Customer where name = ?1 and primaryContact = ?2")
	List<Customer> findVipList(String value1, String value2);

//	@Query(value = "select * from Customer where name = ?1 and address = ?2", nativeQuery=true)
	@Query(value = "select * from Customer where name = ?1 and primary_contact = ?2", nativeQuery=true)
	List<Customer> findVipList2(String value1, String value2);
}
