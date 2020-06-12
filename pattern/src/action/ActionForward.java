package action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionForward {
	private String path;
	private boolean redirect; // redirect = true → sendRedirect로 이동하겠다 / FrontController에서 if문 넣어놨음

}
