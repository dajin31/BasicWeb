package todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/complete")
public class ComplateupdateServlet extends HttpServlet {
//get post 둘다 가능 하지만 get이 더 편하다고 하심
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramtNo = req.getParameter("tNo");
		int tNo = paramtNo == null || paramtNo.isEmpty() ? 0 : Integer.parseInt(paramtNo);
		String paramComplete = req.getParameter("complete");
		boolean complete = paramComplete == null || paramComplete.isEmpty() ? false
				: Boolean.parseBoolean(paramComplete);

		TodoVO todoVO = new TodoVO(tNo, complete);

		TodoService todoService = TodoService.getInstance();
		TodoVO updateComplete = todoService.updateComplete(todoVO);
		
		//업데이트후 데이터 베이스에 존재하는 complete값만 가져오기

		resp.setContentType("application/json");
//		이렇게 하면 .json방식으로 데이터를 보내는거임
		PrintWriter out = resp.getWriter();

		if (todoVO != null) {
			out.print("{\"result\":\"success\",\"complete\":"+updateComplete.isComplete()+"}");
		} else {
			out.print("{\"result\":\"failure\"}");
		}

	}
}
