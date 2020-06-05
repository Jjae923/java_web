create table userTBL(
	no number(4) constraint pk_userTBL primary key,
	username nvarchar2(10) not null,
	birthyear number(4) not null,
	addr nvarchar2(10) not null,
	mobile nvarchar2(15)
);

create sequence user_seq;
