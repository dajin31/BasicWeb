inpackage todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/delete")
public class TodoDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tNo = req.getParameter("tNo") == null || req.getParameter("tNo").isEmpty() ? 0
				: Integer.parseInt(req.getParameter("tNo"));
		TodoService Service =TodoService.getInstance();
		int deleteTodo = Service.deleteTodo(tNo);
		if (deleteTodo > 0) {
			resp.sendRedirect("/todo/list");
		} else {
			req.setAttribute("msg", "실패함..ㅠㅠ");
			req.getRequestDispatcher("/WEB-INF/views/todo/view.jsp").forward(req, resp);
		}

	}

}
