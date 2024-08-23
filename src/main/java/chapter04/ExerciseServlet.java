package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExerciseServlet extends HttpServlet{
	//서블릿이 주방장이라 짜장면을 만듦 요리를 하는내용을 적을거임
	//요청 방식에 따라 메소드가 구분됨
	//method(8개): get, post , put, delete , patch , head , options , connect
	//그중에서 get post put delete 를 많이 사용함.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//메소드를 호출할떄 사용자가 요청하면 req에 들어오고 응답할때 resp에 들어옴.
		PrintWriter out = resp.getWriter();//응답내용을 작성하는 객체
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("</head>"); 
		out.print("<body>");
		out.print("<div>");
		out.print("Hello Servlet!!");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
}
