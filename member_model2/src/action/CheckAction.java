package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.MemberDAO;

public class CheckAction implements Action {

	private String path;
	
	public CheckAction(String path) {
		this.path = path; 
	}
		
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 사용자로부터 아이디를 가져와서 중복되었는지 확인
		String userid = req.getParameter("userid");
		MemberDAO dao = new MemberDAO();
		
		// 그 결과를 request에 담고 페이지 이동
		if(dao.checkId(userid)) {
			req.setAttribute("dupId", "false");
		}else {
			req.setAttribute("dupId", "true");
		}
		return new ActionForward(path, false);
	}
}
