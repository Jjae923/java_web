package action;

public class ActionFactory {
	private static ActionFactory actionFactory;
	
	// 싱글톤?
	private ActionFactory() {}
	public static ActionFactory getInstance() {
		if(actionFactory==null) {
			actionFactory = new ActionFactory();
		}
		return actionFactory;
	}
	
	Action action = null;
	public Action action(String cmd) {
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("result.jsp");
		}else if(cmd.equals("/delete.do")) {
			
		}else if(cmd.equals("/update.do")) {
			
		}else if(cmd.equals("/select.do")) {
			
		}
		return action;
	}
}
