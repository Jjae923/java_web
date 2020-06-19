create table product(
	pno number(8), -- 상품번호
	category varchar2(20), -- 상품 카테고리
	name varchar2(50), -- 상품 이름
	content varchar2(3000), -- 상품의 상세 내용
	psize varchar2(10), -- 상품 사이즈
	color varchar2(20), -- 상품 색상
	amount number(8), -- 상품 수량
	price number(8), -- 상품 가격
	regdate date default sysdate); -- 등록일
	
alter table product add constraint pk_product primary key(pno);
create sequence product_seq;