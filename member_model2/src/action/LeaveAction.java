package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.MemberDAO;

public class LeaveAction implements Action {

	private String path;
	
	public LeaveAction(String path) {
		this.path = path; 
	}
		
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// leaveForm.jsp에서 넘긴 값 가져오기
		String userid = req.getParameter("userid");
		String password = req.getParameter("current_password");
		// DB처리
		MemberDAO dao = new MemberDAO();
		int result = dao.leave(userid, password);
		// 세션해제하기
		if(result>0) {
			HttpSession session = req.getSession(false);
			session.removeAttribute("login");
		}else {
			path = "view/leaveForm.jsp";
		}
		// 경로와 방법 설정
		return new ActionForward(path, true);
	}

}
