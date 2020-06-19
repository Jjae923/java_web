package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductDAO;
import persistence.ProductVO;

public class ProductAddAction implements Action {
	
	private String path;
	
	public ProductAddAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String category = req.getParameter("goods_category");
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String psize = req.getParameter("psize");
		String color = req.getParameter("color");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int price = Integer.parseInt(req.getParameter("price"));

		ProductDAO dao = new ProductDAO();
		ProductVO vo = new ProductVO();
		vo.setCategory(category);
		vo.setName(name);
		vo.setContent(content);
		vo.setPsize(psize);
		vo.setColor(color);
		vo.setAmount(amount);
		vo.setPrice(price);
		System.out.println();
		if(dao.insertProduct(vo)==0) {
			path = "/admin_goods_write.jsp";
		}
			
		return new ActionForward(path, true);
	}

}
