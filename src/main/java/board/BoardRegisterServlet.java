package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;

import file.FileDTO;

@WebServlet("/boards/register")
@MultipartConfig(maxFileSize =10485760)
//@MultipartConfig 어노테이션 또는 web.xml에 추가하지않으면
//multipart/form-data 형식의 파일을 처리할수 없음
public class BoardRegisterServlet extends HttpServlet {
	private static final String FILE_PATH = "c:\\users\\pc22\\upup\\";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//수정,등록시 필요
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		//첨부파일 처리
		//첨부파일과 파라미터를 함게 처리할 수 있다.
		//part: 부분
		//주로 첨부파일만 가져올때 사용하는 경우가 많음
		Part filePart = req.getPart("files");
		long fileSize = filePart.getSize();//첨부파일의 용량
		String originalName = filePart.getSubmittedFileName();//첨부파일 이름
		String contentType = filePart.getContentType();//첨부파일의 컨텐츠 타입
		//첨부파일은 업로드시 이름이 똑같을때 기존에 있는파일을 덮어씀..
		//그래서 random의 이름을 만들어서 넣음.
		//첨부파일 업로드시 회사에서 만드는 첨부파일의 용량이 하루에 천개만개씩 들어올때
		//파일이 너무 많아서 그거를 하나의 폴더에 넣으면 관리하기 힘들기 때문에 path를 만들어서 폴더를 관리하려고 path를씀.
		
		System.out.println("업로드된 파일 크기: " + fileSize );
		System.out.println("업로드된 파일 이름: " + originalName );
		System.out.println("업로드된 파일 컨텐츠: " + contentType );
		
		//실제 물리적인 서버 위치에 파일을 저장하기
		//리눅스 맥에서는 다음과 같이 작성
//		filePart.write("c:\\users\\pc22\\upup\\"+ originalName);
		String fileName = UUID.randomUUID().toString();
		filePart.write(FILE_PATH+ fileName);
		
		
		
		BoardDTO board = new BoardDTO(title,content,writer);
		//파일정보 넣어주기
		List<FileDTO> fileList = new ArrayList<FileDTO>();
		fileList.add(new FileDTO(FILE_PATH,fileName,originalName,fileSize));
		board.setFileList(fileList);
		
		ServletContext context = req.getServletContext();
		SqlSession session = (SqlSession) context.getAttribute("sqlSession");
		BoardService service = BoardService.getInstance(session);
		
		int registerBoard = service.registerBoard(board);
		if (registerBoard > 0 ) {
			resp.sendRedirect("/boards");
		} else {
			req.setAttribute("msg", "아이쿠! 실패했어용..ㅠㅠㅠ 괜찮아...");
			req.getRequestDispatcher("WEB-INF/views/board/register.jsp").forward(req, resp);

		}
	}
}
