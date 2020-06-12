package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction implements Action {
	private String path;
	
	public InsertAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//사용자가 요청한 작업 처리
		System.out.println("******* "+req.getParameter("name"));
		// DB작업
		
		// 화면전환 결과 전송
		return new ActionForward(path, false);
	}
}
