package action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActionForward {
	private String path; // 움직일 경로 설정
	private boolean redirect; // 움직이는 방법 설정
}
