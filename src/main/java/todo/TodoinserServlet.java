package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/insert") // 이렇게 하면 서블릿등록한것과 똑같음
public class TodoinserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/todo/insert.jsp").forward(req, resp);
//		여기위에 있는 url에 떠넘김
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String paramDueDate = req.getParameter("dueDate");
		LocalDate dueDate = paramDueDate == null || paramDueDate.isEmpty() ? LocalDate.now()
				: LocalDate.parse(paramDueDate);

		TodoService todoService = TodoService.getInstance();
		int insertTodo = todoService.insertTodo(new TodoVO(title, writer, dueDate));
//		호출할때 값을 넣어줌.
		if (insertTodo > 0) {
			resp.sendRedirect("/todo/list");
		} else {
			req.setAttribute("msg", "띠로리....실패함 ㅠㅠ");
//			msg를 attribute에 담았기 떄문에 insert jsp 에서 해당 메세지를 노출시켜줌
			req.getRequestDispatcher("/WEB-INF/views/todo/insert.jsp").forward(req, resp);
		}
	}
}