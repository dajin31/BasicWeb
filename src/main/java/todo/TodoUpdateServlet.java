package todo;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class TodoUpdateServlet extends HttpServlet {
//업데이트 할때는 get, post가 같이 있어야함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		여기가 클라이언트로 받는거
		String updateTNo = req.getParameter("tNo");
		int tNo = updateTNo == null || updateTNo.isEmpty() ? 0 : Integer.parseInt(updateTNo);
//		서버에서 하는거
		TodoService service = TodoService.getInstance();
		TodoVO todo = service.selectTodo(tNo);
//		응답하는거
		req.setAttribute("todo", todo);
		req.getRequestDispatcher("/WEB-INF/views/todo/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String paramTNo = req.getParameter("tNo");
		int tNo = paramTNo == null || paramTNo.isEmpty() ? 0 : Integer.parseInt(paramTNo);

		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String paramDueDate = req.getParameter("dueDate");
		LocalDate dueDate = paramDueDate == null || paramDueDate.isEmpty() ? null : LocalDate.parse(paramDueDate);
		// ↑사용자한테 받은 데이터
		TodoVO todoVO = new TodoVO(tNo, title, writer, false, dueDate);
//		여기서 받은값이 DAO에 호출이 되서 파라미터 값을 전달
		TodoService todoService = TodoService.getInstance();
//		서버쪽에서 업데이트
		int updateTodo = todoService.updateTodo(todoVO);
		// 성공실패확인
		if (updateTodo > 0) {
			resp.sendRedirect("/todo/list");
		} else {
			req.setAttribute("msg", "또???실패????");
			req.getRequestDispatcher("/WEB-INF/views/todo/update.jsp").forward(req, resp);
		}

	}
}
