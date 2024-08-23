package chapter05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class memberListServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe","std202","oracle21c");
		statement = connection.createStatement();
		String sql = "select mem_id,mem_name,mem_hp,mem_mail from member where mem_del_yn !='Y'";
		resultSet = statement.executeQuery(sql);
	
		while (resultSet.next()){
		 String memId = resultSet.getString("mem_id");
		 String memName = resultSet.getString("mem_name");
		 String memHp = resultSet.getString("mem_hp");
		 String memMail = resultSet.getString("mem_mail");
		 arrayList.add(new MemberDTO(memId,memName,memHp,memMail));
		 //이 부분에서 데이터를 화면에 출력
		}
	}catch (Exception e) {
		e.printStackTrace();
	
	}finally {
		try {
			if(resultSet !=null) {
				resultSet.close();
			}
			if(statement !=null) {
			statement.close();
			}
			if(connection !=null) {
			connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//list 객체를 다음 서블릿(또는JSP) 에게 보내는 방법
		req.setAttribute("members",arrayList); //HashMap과 비슷한 형태로 객체를 저장
		//담은걸 화면으로 요청을 위임(dispacher)
		req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);
	}
}
