package action;

public class ProductActionFactory {
	private static ProductActionFactory factory;
	
	private ProductActionFactory() {}
	public static ProductActionFactory getInstance() {
		if(factory==null) {
			factory = new ProductActionFactory();
		}
		return factory;
	}
	
	private Action action = null;
	public Action action(String cmd) {
		if(cmd.equals("/insert.do")) {
			action = new ProductAddAction("list.do");
		}
		else if(cmd.equals("/list.do")) {
			action = new ProductListAction("/admin_goods_list.jsp");
		}
		return action;
	}

}
