package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import todo.TodoService;

@WebServlet("/boards/remove")
public class BoardRemoveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = req.getParameter("id") == null || req.getParameter("id").isEmpty() ? 0 : Integer.parseInt(req.getParameter("id"));
	ServletContext context = req.getServletContext();
	SqlSession session = (SqlSession) context.getAttribute("sqlSession");
	BoardService service = BoardService.getInstance(session);
	int removeBoard = service.removeBoard(id);
	
	if(removeBoard > 0 ) {
		resp.sendRedirect("/boards");
	}else {
		req.setAttribute("msg", "썅..");
		req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
	}
	
	}
}
