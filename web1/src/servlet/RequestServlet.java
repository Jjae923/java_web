package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/request")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		// HttpServletRequest 로 가져올 수 있는 정보들
		PrintWriter out = res.getWriter();
		out.printf("Request URI : %s<br>", req.getRequestURI());
		out.printf("Request URL : %s<br>", req.getRequestURL());
		out.printf("Context Path : %s<br>", req.getContextPath()); // 현재 동작(서비스)하고있는 프로젝트명
		out.printf("Request Protocol : %s<br>", req.getProtocol());
		out.printf("Client Address : %s<br>", req.getRemoteAddr());
		out.printf("Client Port : %s", req.getRemotePort());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
