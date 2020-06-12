package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionFactory;
import action.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 어디서 온 요청인지 알아내기(cmd 분석)
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());

		//출력 확인용
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("requestURI "+requestURI+"<br>");
//		out.print("contextPath "+contextPath+"<br>");
//		out.print("cmd "+cmd);
		
		// Action 생성하기
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		// 생성된 Action 일 시키기
		ActionForward af = null;
		try {
			af = action.execute(request, response); // 사용자가 요청한 작업을 넘겨줌
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 결과 페이지로 이동하기
		if(af.isRedirect()) {
			response.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
