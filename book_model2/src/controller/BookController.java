package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.ActionForward;
import action.BookActionFactory;

@WebServlet("*.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 한글 인코딩 설정
		req.setCharacterEncoding("utf-8");
		
		// 요청 파악하기
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		// 분석된 cmd에 의해 Action 생성하기
		BookActionFactory baf = BookActionFactory.getInstance();
		Action action = baf.action(cmd);
		
		// 생성된 Action 일 시키기
		ActionForward af = null;
		try {
			af = action.execute(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 페이지 이동 방식에 따라 이동하기
		if(af.isRedirect()) {
			res.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
			rd.forward(req, res);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
