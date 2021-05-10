package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import lombok.Data;

// Entity로 만들기 위행 @Entity를 하고 @Id를 해주면 된다.
// 실행 시 Entity로 인식하고 테이블이 없을 경우 테이블 생성
//@Data // getter, setter 자동으로 생성(@Data가 안되서 구현)
@Entity
public class Customer {
	@Id
//	@GeneratedValue // id 자동 생성
	@GeneratedValue(strategy = GenerationType.IDENTITY) // data.sql문을 사용할 때 id값을 자동 생성하기 위함
	private int id;
	private String name;
	@Column(length=1024) // address 길이 설정
	private String address;
	private String primaryContact; // 이런식으로 추가를 하면 h2에 PRIMARY_CONTACT 가 생긴다.
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}