package login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import chapter05.MemberDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		post방식으로 요청을 처리
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String rememberMe = req.getParameter("rememberMe");

		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		LoginService service = LoginService.getInstance(session);
		MemberDTO member = service.findMemberById(userId, userPw);
//		session : req에서 가져옴
//		cookie : resp에 저장
		if (member != null) {
			// 로그인처리
			HttpSession session2 = req.getSession();// 세션을 가져옴
			session2.setAttribute("member", member);// 세션에 담음
			
			Cookie rememberId = new Cookie("rememberId", userId);
			if("remember-me".equals(rememberMe)) {
				// remember-me라는 글자가 같으면
				rememberId.setMaxAge(60*60*24*7);
				// 유효시간임 60*60*24 이게 하루임 60초 60분 24하루
				rememberId.setPath("/");
//				패스를 지정하지 않은면 현재 요청 url 에서만 동작
				// 넣은다음 생성
			}else {
				rememberId.setPath("/");
				//체크박스 해제후 로그인시 쿠키 삭제
				rememberId.setMaxAge(0);
			}
			resp.addCookie(rememberId);
			
			String retUrl = (String) session2.getAttribute("retUrl");
			// url을 가져와서 로그인체크부분에서 로그인이 되어있지 않으면 원래 있던 주소값을 세션에 보낸다음
			// 그받은값을 ..?
			if (retUrl != null) {
				// 세션에서 url정보 삭제
				session2.removeAttribute("retUrl");
				resp.sendRedirect(retUrl);
			} else {
				resp.sendRedirect("/boards");
//			↑ 로그인 성공시 가는 화면 

			}
		} else {
			// 로그인 실패
			req.setAttribute("mas", "아이디 비번 다시확인하삼");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}

	}
}
