package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		session.removeAttribute("member");
//		↑ 세션에서 member만 삭제한다
//		세션에서 모든 데이터를 삭제할때는 invalidate()를 사용한다
//		주로 세션을 제거할때는 속성값을 하나하나지정하는것보다
//		invalidate()함수를 이용해서 모든값을 지운다
		session.invalidate();
//		↑ 세션에서 모든값을 지운다.
		resp.sendRedirect("/boards");
	}
}
