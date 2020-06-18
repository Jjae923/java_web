package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

public class ListAction implements Action {
	
	private String path;
	
	public ListAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		
		List<BoardVO> list = dao.getList();
		
		if(!list.isEmpty()) { // BoardDAO dao = new BoardDAO();를 했기 때문에 내용이 비어있을지언정 객체는 생성되어있음 -> null로 불가능
			req.setAttribute("list", list); // 이부분이 있기 때문에 qna_board_list.jsp 에서 ${list} 가 동작 가능
		}
		return new ActionForward(path, false);
	}
}
