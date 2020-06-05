package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnimalServlet
 */
@WebServlet("/animal")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 가져오는 데이터 한글 인코딩 설정
		req.setCharacterEncoding("utf-8");
		
		// 보여주는 페이지 컨텐트타입 설정
		res.setContentType("text/html; charset=UTF-8");

		// 데이터 가져오기
//		String animal = req.getParameter("animal"); // 하나의 값만 가져올 수 있음
		String animal[] = req.getParameterValues("animal");
		
		// 가져온 데이터 화면에 출력하기
		PrintWriter out = res.getWriter();
		for(String s:animal) {
			out.print("<h2>"+s+"</h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
