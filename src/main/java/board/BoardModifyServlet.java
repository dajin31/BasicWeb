package board;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/boards/modify")
public class BoardModifyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramid = req.getParameter("id");
		int id = paramid ==null || paramid.isEmpty() ? 0 : Integer.parseInt(paramid);
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		BoardService service = BoardService.getInstance(session);
		BoardDTO board = service.selectBoard(id);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/WEB-INF/views/board/modify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramid = req.getParameter("id");
		//수정삭제시 필요↓
		int id = paramid ==null || paramid.isEmpty() ? 0 : Integer.parseInt(paramid);
		//수정,등록시 필요↓
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardDTO board = new BoardDTO(id,title,content,writer);
		
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		BoardService service = BoardService.getInstance(session);
		
		int modifyBoard = service.modifyBoard(board);
		
		if (modifyBoard > 0 ) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "아이쿠! 실패했어용..ㅠㅠㅠ 괜찮아...");
			req.getRequestDispatcher("WEB-INF/views/board/modify.jsp").forward(req, resp);

		}
		
		
	}
}
