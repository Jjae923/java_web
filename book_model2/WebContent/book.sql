create table bookTBL(
	code varchar2(4) primary key,
	title nvarchar2(50) not null,
	writer nvarchar2(10) not null,
	price number(8));

insert into bookTBL values('1001', '이것이 자바다', '신용균', 25000);	
insert into bookTBL values('1002', '자바의 신', '김영숙', 30000);
insert into bookTBL values('1003', '자바의 정석', '남궁성', 27000);
insert into bookTBL values('1004', '파이썬', '이민호', 28000);


