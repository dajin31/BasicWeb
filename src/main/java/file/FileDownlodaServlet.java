package file;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import board.BoardService;

@WebServlet("/file/download")
public class FileDownlodaServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		int id = paramId == null || paramId.isEmpty() ? 0 : Integer.parseInt(paramId);
		
		ServletContext context = req.getServletContext();
		SqlSession sqlSession = (SqlSession) context.getAttribute("sqlSession");
		
		FileService service = FileService.getInstance(sqlSession);
		FileDTO file = service.selectFile(id);
		//첨부파일만 응답해야한다. 응답할때 html코드로 응답을 하는데 파일자체가 sql코드로 응답됭랴함
		
		String filePath = file.getFilePath();
		String fileName = file.getFileName();
//		이위치에 존재하는 파일을 가져와야함. 
		
		//한글 이름 파일은 인코딩을 해줘야함
		String encode = URLEncoder.encode(file.getOriginalName(),"UTF-8").replaceAll("\\+", " ");
		
//		이렇게하면 첨부파일이 이상하게 보임. 파일명을 입혀서 응답을 해줘야함.,
//		그걸해결하기 위해 응답할때 헤더에 파일정보를 알려줌
		
		//응답헤더 정의
		resp.setContentType("application/octet-stream"); //8비트 스트림 파일
//		응답객체의 타입이 뭐냐
		
		resp.setHeader("Content-Disposition", "attachment;filename=\""+encode+"\"");
//		다운로드 받을때 이첨부파일 이름으로 다운됨.
		
		resp.setHeader("Content-Length", String.valueOf(file.getFileSize()));
		
		//첨부파일만 응답해야함. 응답바디
		Path path = Paths.get(filePath,fileName);	
		
		ServletOutputStream outputStream = resp.getOutputStream();
		//getOutputStream이 물리적인 파일을 가져와서 쏴야함..

		Files.copy(path, outputStream);
//		첨부파일 위치에 파일을 읽어와서 path를 받아서 아웃풋스트림으로 쏴줌
		
	}
	
}
