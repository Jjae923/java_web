package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.BookVO;

public class BookDAO {
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection getConnection() {
//		try {
//			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			String user = "javadb";
//			String password = "12345";
//			return DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public static Connection getConnection() {
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); // java:/comp/env에 저장된 
			DataSource ds = (DataSource)envContext.lookup("jdbc/Oracle"); // jdbc/Oracle를 찾아와줘
			return ds.getConnection();
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
	
	// book insert 작업
	public int bookInsert(BookVO vo) {
		String sql = "insert into bookTBL values(?,?,?,?)";
		
		int result = 0;
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 도서 목록 삭제
	public boolean bookDelete(String code) {
		String sql = "delete from bookTBL where code=?";
		
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, code);
				
				int result = pstmt.executeUpdate();
				if(result > 0)
					return true;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	// 도서 목록 수정
	public int bookModify(String code, int price) {
		String sql = "update bookTBL set price =? where code =?";
		
		int result = 0;
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, price);
				pstmt.setString(2, code);
				
				result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 도서 목록 검색
	public List<BookVO> searchList(String criteria, String keyword){
		List<BookVO> search = new ArrayList<BookVO>();
		
		String sql ="";
		if(criteria.equals("code")) {
			sql = "select * from bookTBL where code=?";
		}else { // 작가
			sql = "select * from bookTBL where writer=?";
		}
		
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, keyword);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					BookVO vo = new BookVO();
					vo.setCode(rs.getString(1));
					vo.setTitle(rs.getString(2));
					vo.setWriter(rs.getString(3));
					vo.setPrice(rs.getInt(4));
					search.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return search; 
	}
}
