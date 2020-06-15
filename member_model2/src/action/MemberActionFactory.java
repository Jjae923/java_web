package action;

public class MemberActionFactory {
	private static MemberActionFactory factory;
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if(factory == null) {
			factory = new MemberActionFactory();
		}
		return factory;
	}

	private Action action = null;
	public Action action(String cmd) {
		
		if(cmd.equals("/login.do")) {
			action = new LoginAction("view/loginForm.jsp");
		}else if(cmd.equals("/logout.do")) {
			action = new LogoutAction("index.jsp");
		}else if(cmd.equals("/modify.do")) {
			action = new ModifyAction("view/loginForm.jsp");
		}else if(cmd.equals("/leave.do")) {
			action = new LeaveAction("index.jsp");
		}else if(cmd.equals("/join.do")) {
			action = new JoinAction("view/loginForm.jsp");
		}
		
		return action;
	}
}
