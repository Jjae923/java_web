package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.PageVO;
import domain.SearchVO;
import persistence.BoardDAO;

public class ListAction implements Action {
	
	private String path;
	
	public ListAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// search에서 넘어오는 값 가져오기
		// criteria, keyword
		String criteria = req.getParameter("criteria");
		String keyword = req.getParameter("keyword");
		
		/***** 페이지 나누기 *****/
		int page = 1; // index 실행 시 값이 넘어올 게 없기 때문에 초기값 설정
		if(req.getParameter("page")!=null) // 페이지값 넘어온 경우
			page = (Integer.parseInt(req.getParameter("page")));
		
		// 한 페이지당 보여줄 게시물 수
		int amount = 10;
		
		SearchVO search = new SearchVO(criteria, keyword, page, amount);
		BoardDAO dao = new BoardDAO();
		
		// 전체 게시물 수
		int total = dao.totalRows(criteria,keyword);
		PageVO pageVO = new PageVO(total, search);		
		List<BoardVO> list = dao.getList(search);
		
		if(!list.isEmpty()) { // BoardDAO dao = new BoardDAO();를 했기 때문에 내용이 비어있을지언정 객체는 생성되어있음 -> null로 불가능
			req.setAttribute("list", list); // 이부분이 있기 때문에 qna_board_list.jsp 에서 ${list} 가 동작 가능
			req.setAttribute("pageVO", pageVO);
		}
		return new ActionForward(path, false);
	}
}
