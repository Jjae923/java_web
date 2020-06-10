package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.MemberVO;

public class MemberDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javadb";
			String password = "12345";
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 로그인 처리 (select) 아이디와 이름이 return 되도록
	public MemberVO isLogin(String userid, String password) {
		String sql = "select * from member where userid = ? and password = ?";
		
		int result;
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setUserid(rs.getString("userid"));
					vo.setName(rs.getString("name"));
					return vo;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;		
	}
	
	// 비밀번호 변경
	public int passwordUpdate(String userid, String new_password, String current_password) {
		String sql = "update member set password = ? where userid = ? and password = ?";
		
		int result = 0;
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, new_password);
				pstmt.setString(2, userid);
				pstmt.setString(3, current_password);
				result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
		
	}

}
