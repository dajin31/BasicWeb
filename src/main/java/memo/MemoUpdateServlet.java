package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/update")
public class MemoUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String updateMno = req.getParameter("mNo");
		int mNo = updateMno == null || updateMno.isEmpty() ? 0 : Integer.parseInt(updateMno);

		MemoService service = new MemoService();
		MemoVO memo = service.selectMemo(mNo);

		req.setAttribute("memo", memo);
		req.getRequestDispatcher("/WEB-INF/views/memo/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String paramMNO = req.getParameter("mNo");
		int mNO = paramMNO == null || paramMNO.isEmpty() ? 0 : Integer.parseInt(paramMNO);

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		MemoVO memoVO = new MemoVO(mNO, title, content, writer);

		MemoService memoService = new MemoService();

		int updateMemo = memoService.updateMemo(memoVO);

		if (updateMemo > 0) {
			resp.sendRedirect("/memo/get");
		} else {
			req.setAttribute("msg", "띠로리..한번에 성공한적이 없냐..");
			req.getRequestDispatcher("/WEB-INF/views/memo/update.jsp").forward(req, resp);
		}

	}
}
