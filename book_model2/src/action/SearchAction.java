package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

public class SearchAction implements Action {
	private String path;	

	public SearchAction(String path) {
		super();
		this.path = path;
	}
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// book_search.jsp에서 넘긴 값 가져오기
		String criteria = req.getParameter("criteria");
		String keyword = req.getParameter("keyword");
		// DB작업
		BookDAO dao = new BookDAO();
		List<BookVO> search = dao.searchList(criteria, keyword);
		// 검색결과 가져오기
		req.setAttribute("search", search);
		return new ActionForward(path, false);
	}
}
