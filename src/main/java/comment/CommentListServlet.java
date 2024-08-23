package comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("boardId");
		int boardId = paramId == null || paramId.isEmpty() ? 0 : Integer.parseInt(paramId);
		
		ServletContext context = req.getServletContext();
		SqlSession attribute = (SqlSession) context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(attribute);

		List<CommentDTO> selectComments = service.selectComments(boardId);
		req.setAttribute("commentList", selectComments);
		
		
	}
}
