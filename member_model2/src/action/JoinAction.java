package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVO;
import persistence.MemberDAO;

public class JoinAction implements Action {

	private String path;
	
	public JoinAction(String path) {
		this.path = path; 
	}
		
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// JoinForm.jsp에서 넘긴 값 가져오기
		MemberVO member = new MemberVO();
		member.setUserid(req.getParameter("userid"));
		
		String password = req.getParameter("password");
		String confirm_password = req.getParameter("confirm_password");
		member.setName(req.getParameter("name"));
		member.setGender(req.getParameter("gender"));
		member.setEmail(req.getParameter("email"));
		// DB 처리
		if(password.equals(confirm_password)){
			member.setPassword(password);
		}else {
			path = "view/joinForm.jsp";
		}
		MemberDAO dao = new MemberDAO();
		int result = dao.register(member);
		if(result==0) {
			path = "view/joinForm.jsp";
		}
		// 경로와 방법 설정
		return new ActionForward(path, true);
	}
}
