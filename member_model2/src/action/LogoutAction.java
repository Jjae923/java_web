package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	private String path;
	
	public LogoutAction(String path) {
		this.path = path; 
	}
		
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 세션에 해제 후 이동
		//req.getSession(boolean); => 세션이 없는 경우 true, false 값에 의해서 세션을 생성여부 결정
		//req.getSession(); => 세션이 없는 경우 새로운 세션을 무조건 생성
		HttpSession session = req.getSession(false); // 기존에 있는 세션
		session.removeAttribute("login");
		// 경로와 방법 설정
		return new ActionForward(path, true);
	}
}
