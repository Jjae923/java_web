package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "javadb";
		String password = "12345";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int userInsert(UserVO vo) {
		Connection con = getConnection();
		String sql = "insert into userTBL values(user_seq.nextVal,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserName());
			pstmt.setInt(2, vo.getBirthYear());
			pstmt.setString(3, vo.getAddr());
			pstmt.setString(4, vo.getMobile());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // finally : 무조건 실행 / 네트워크 쪽 연결한 자원들을 해제하는 작업
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 전체 User 가져오기
	public List<UserVO> getList(){
		List<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from userTBL";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
					
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setNo(rs.getInt(1));
				vo.setUserName(rs.getString(2));
				vo.setBirthYear(rs.getInt(3));
				vo.setAddr(rs.getString(4));
				vo.setMobile(rs.getString(5));
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	// 삭제
	// delete from userTBL where no=? and userName=?
	public int userDelete(int no, String userName) {
		int result = 0;
		String sql = "delete from userTBL where no=? and userName=?";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, no);
				pstmt.setString(2, userName);
				
				result = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
