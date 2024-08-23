package comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/comments/new")
public class CommentRegisterServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//request의 getparameter()메소드는 요청 헤더 (Rdquest Header)에 
		//Content-type이 application/x-www-from-urlencnde로 되어있어야 처리가 가능함.
		
		
		String paramId = req.getParameter("boardId");
		int boardId = paramId == null || paramId.isEmpty() ? 0 : Integer.parseInt(paramId);
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		ServletContext context = req.getServletContext();
		SqlSession attribute = (SqlSession) context.getAttribute("sqlSession");
		CommentService service = CommentService.getInstance(attribute);

		CommentDTO comment = new CommentDTO(boardId, content, writer);
		CommentDTO newCommnet = service.registerComment(comment);

		//응답을 json형식으로 해준다.
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String json = """
		    {
				"id":%d,
				"boardId":%d,
				"content":"%s",
				"writer":"%s",
				"registerDate":"%s",
				"modifiedDate":"%s"
			}	
			""".formatted(
					newCommnet.getId(),newCommnet.getBoardId(),
					newCommnet.getContent(),newCommnet.getWriter(),
					newCommnet.getRegisterDate(),newCommnet.getModifiedDate()
					);
		out.println(json);
	}
}
