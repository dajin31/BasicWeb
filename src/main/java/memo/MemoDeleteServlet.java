package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/delete")
public class MemoDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mNO = req.getParameter("mNo") == null || req.getParameter("mNo").isEmpty() ? 0 :
				Integer.parseInt(req.getParameter("mNo"));
		MemoService memoService = new MemoService();
		int deleteMemo = memoService.deleteMemo(mNO);
		if(deleteMemo > 0) {
			resp.sendRedirect("/memo/get");
		}else {
			req.setAttribute("msg", "실패실패 왕실패");
			req.getRequestDispatcher("/WEB-INF/views/memo/view.jsp").forward(req, resp);
		}
	}
}
