package action;

public class BoardActionFactory {
	private static BoardActionFactory factory;
	
	private BoardActionFactory() {}
	public static BoardActionFactory getInstance() {
		if(factory==null) {
			factory = new BoardActionFactory();
		}
		return factory;
	}
	
	private Action action = null;
	public Action action(String cmd) {
		return action;
	}
}
