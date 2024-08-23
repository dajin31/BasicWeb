package common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chapter05.MemberDTO;

@WebFilter("/boards/register")
public class LoginCheckFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if (member != null) {
			super.doFilter(req, res, chain);
		} else {
			session.setAttribute("retUrl", req.getRequestURI());
			res.sendRedirect("/login");
		}
	}
}
