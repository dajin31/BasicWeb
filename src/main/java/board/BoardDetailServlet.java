package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;


@WebServlet("/boards/detail")
public class BoardDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramid = req.getParameter("id");
		int id = paramid == null || paramid.isEmpty() ? 0 : Integer.parseInt(paramid);
		
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		BoardService service = BoardService.getInstance(session);
		
		BoardDTO board = service.selectBoard(id);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
	}


}