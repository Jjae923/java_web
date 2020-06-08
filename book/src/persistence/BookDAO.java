package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import domain.BookVO;

public class BookDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
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
	
	// bookTBL 전체 내용 출력
	public List<BookVO> getList(){
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from bookTBL";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getString(1));
				vo.setTitle(rs.getString("Title"));
				vo.setWriter(rs.getString("Writer"));
				vo.setPrice(rs.getInt("Price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
