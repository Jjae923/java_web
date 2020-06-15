package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.BookDAO;

public class ModifyAction implements Action {
	private String path;	

	public ModifyAction(String path) {
		super();
		this.path = path;
	}
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// book_modify.jsp에서 넘긴 값 가져오기
		String code = req.getParameter("code");
		int price = Integer.parseInt(req.getParameter("price"));
		// DB작업
		BookDAO dao = new BookDAO();
		if(dao.bookModify(code, price)==0) { // 실패
			path = "index.jsp?tab=modify";
		}
		// 경로와 방법 설정 후 리턴
		return new ActionForward(path, true);
	}
}
