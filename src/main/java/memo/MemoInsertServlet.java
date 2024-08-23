package memo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memo/insert")
public class MemoInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/memo/new.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		MemoService memoService = new MemoService();
		int insertMemo = memoService.insertMemo(new MemoVO(title,content,writer));
		if(insertMemo > 0) {
			resp.sendRedirect("/memo/get");
		}else {
			req.setAttribute("msg","띠로리~~~실패ㅠㅠ");
			req.getRequestDispatcher("/WEB-INF/views/memo/new.jsp").forward(req, resp);
		}
	
	
	
	}
	

}
