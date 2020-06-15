package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
	public MemberVO(String userid, String password, String name, String gender, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}
	
//	public boolean password_equalTo_confirm(String newPassword) {
//		return password.equals(newPassword);
//	}
}
