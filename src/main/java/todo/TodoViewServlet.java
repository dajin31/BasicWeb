package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/view")
public class TodoViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int searchTNo = req.getParameter("tNo") != null ? Integer.parseInt(req.getParameter("tNo")) : 0;
		TodoService service = TodoService.getInstance();
		TodoVO todo = service.selectTodo(searchTNo);

		req.setAttribute("todo", todo);
		req.getRequestDispatcher("/WEB-INF/views/todo/view.jsp").forward(req, resp);
	}
}
