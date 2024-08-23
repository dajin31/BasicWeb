package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String depart = req.getParameter("DEPART");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet executeQuery = null;
		StudentDTO studentDTO = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			String sql = """
					SELECT
						SNO,
						DEPART,
						NAME,
						ADDRESS,
						PHONE
					FROM
						STUDENT
					WHERE
						DEPART=?
					   """;
			statement = connection.prepareStatement(sql);
			statement.setString(1, depart);
			executeQuery = statement.executeQuery();
			while (executeQuery.next()) {
				String sno = executeQuery.getString("sno");
				String Depart = executeQuery.getString("depart");
				String name = executeQuery.getString("name");
				String address = executeQuery.getString("address");
				String phone = executeQuery.getString("phone");

				studentDTO = new StudentDTO(sno, Depart, name, address, phone);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				executeQuery.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("student", studentDTO);
		req.getRequestDispatcher("/WEB-INF/views/student/StudentUpdate.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String oldDepart = req.getParameter("oldDepart");
		String newDepart = req.getParameter("newDepart");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202",
					"oracle21c");
			String sql = """
					     update
					     	student
					     set
					     	depart = ?
					     where
					     	depart = ?
					""";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(2, oldDepart);
			statement.setString(1, newDepart);

			int executeUpdate = statement.executeUpdate();
			if (executeUpdate > 0) {
				resp.sendRedirect("/list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}