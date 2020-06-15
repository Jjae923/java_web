package action;

public class BookActionFactory {
	private static BookActionFactory baf;
	
	private BookActionFactory() {}
	public static BookActionFactory getInstance() {
		if(baf==null) {
			baf = new BookActionFactory();
		}
		return baf;
	}

	Action action = null;
	public Action action(String cmd) {
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("select.do");
		}else if(cmd.equals("/select.do")) {
			action = new SelectAction("book_selectAll.jsp");
		}else if(cmd.equals("/delete.do")) {
			action = new DeleteAction("select.do");
		}else if(cmd.equals("/modify.do")) {
			action = new ModifyAction("select.do");
		}else if(cmd.equals("/search.do")) {
			action = new SearchAction("book_searchAll.jsp");
		}
		return action;
	}
}
