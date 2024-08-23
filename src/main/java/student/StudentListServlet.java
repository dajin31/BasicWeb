package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<StudentDTO> arrayList = new ArrayList<StudentDTO>();
		Connection connection = null;
		Statement statement = null;
		ResultSet executeQuery = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			statement = connection.createStatement();
			String sql = "select * from Student";
			executeQuery = statement.executeQuery(sql);
			while (executeQuery.next()) {
				String no = executeQuery.getString("SNO");
				String DEPART = executeQuery.getString("DEPART");
				String NAME = executeQuery.getString("NAME");
				String ADDRESS = executeQuery.getString("ADDRESS");
				String PHONE = executeQuery.getString("PHONE");
				arrayList.add(new StudentDTO(no, DEPART, NAME, ADDRESS, PHONE));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (executeQuery != null) {
					executeQuery.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		req.setAttribute("student", arrayList);
		req.getRequestDispatcher("/WEB-INF/views/student/student.jsp").forward(req, resp);
	}
}
