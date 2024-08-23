package chapter04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답의 콘텐츠 타입과 인코딩 설정
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>");
        out.print("Insert title here");
        out.print("</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<form>");
        out.print("<div>");
        out.print("<label>");
        out.print("<input type=\"text\" placeholder=\"아이디\">");
        out.print("</label>");
        out.print("</div>");
        out.print("<div>");
        out.print("<label>");
        out.print("<input type=\"password\" placeholder=\"패스워드\">");
        out.print("</label>");
        out.print("</div>");
        out.print("<div>");
        out.print("<button>");
        out.print("로그인");
        out.print("</button>");
        out.print("<button>");
        out.print("취소");
        out.print("</button>");
        out.print("</div>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }
}