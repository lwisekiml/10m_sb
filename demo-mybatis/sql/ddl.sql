-- 한글 사용 가능하도록 설정
create database mybatis_db default character set utf8mb4 default collate utf8mb4_general_ci;

-- DB 사용할 계정 생성 ( '%' 의미 : 어떠한 host에서 접속을 해도 mybatis계정 사용 가능)
create user 'mybatis'@'%' identified by 'mybatis1234';

-- 계정이 생성한 DB를 마음대로 사용가능하도록 설정
grant all on mybatis_db.* to 'mybatis'@'%';

use mybatis_db;

create table company (
	id INTEGER auto_increment primary key,
	company_name VARCHAR(128),
	company_address VARCHAR(128),
	index (company_name)
)

select * from company;

delete from company;

--------------------------------------------------------------------------
create table employee (
	id INTEGER auto_increment primary key,
	company_id INTEGER,
	employee_name VARCHAR(128),
	employee_address VARCHAR(128),
	index (employee_name),
	foreign key (company_id) references company(id)
)

select * from employee;

delete from employee;

-- company에 있는 id값의 숫자를 company_id에 넣어야 함
INSERT INTO employee(company_id, employee_name, employee_address) values(8, '홍길순', '서울시 강남구 대치2동')