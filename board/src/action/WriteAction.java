package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;
import utils.FileUploadUtils;

public class WriteAction implements Action {

	private String path;
	
	public WriteAction(String path) {
		this.path = path;
	}	
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// qna_board_write.jsp에서 넘긴 값 가져오기
//		String name = req.getParameter("name");
//		String password = req.getParameter("password");
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
//		String attach = req.getParameter("attach");

		FileUploadUtils upload1 = new FileUploadUtils();
		HashMap<String,String> uploadMap = upload1.upload(req);
		
		String name = uploadMap.get("name");
		String password = uploadMap.get("password");
		String title = uploadMap.get("title");
		String content = uploadMap.get("content");
		String attach = uploadMap.get("attach");
		
		// 1페이지 / criteria, keyword == ""
		String page = "1";
		String criteria = "";
		String keyword = "";
		
		// DB작업
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setTitle(title);
		vo.setContent(content);
		if(uploadMap.containsKey("attach")) {
			vo.setAttach(attach);
		}
		
		if(dao.insertArticle(vo)==0) {
			path = "view/qna_board_write.jsp";
		}
		return new ActionForward(path, true);
	}
}
