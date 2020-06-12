package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

public class InsertAction implements Action {

	private String path;
	
	public InsertAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 사용자가 요청한 작업 처리하기
		// 사용자가 입력한 값 가져오기
		String code = req.getParameter("code");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String price = req.getParameter("price");
		
		// db 작업 후 성공하면 전체 리스트 보여주기
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();
		vo.setCode(code);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setPrice(Integer.parseInt(price));
		
		// DB 입력이 실패하는 경우 path 재설정
		if(dao.bookInsert(vo) == 0){
			path = "index.jsp";
		}	
		return new ActionForward(path, true);
	}
}
