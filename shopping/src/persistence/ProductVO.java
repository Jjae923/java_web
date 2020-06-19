package persistence;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	private int pno;
	private String category;
	private String name;
	private String content;
	private String psize;
	private String color;
	private int amount;
	private int price;
	private Date regdate;
}
