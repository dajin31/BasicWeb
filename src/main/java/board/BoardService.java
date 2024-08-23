package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlsession;
import file.FileDTO;

public class BoardService {
	private static BoardService instance = new BoardService();
	private static BoardMapper mapper;
	
	
	private BoardService() {
		SqlSession session = MySqlsession.getSqlSession();
//		mapper = session.getMapper(BoardMapper.class);
	}
	public static BoardService getInstance(SqlSession session) {
		mapper = session.getMapper(BoardMapper.class);
		return instance;
	}
	List<BoardDTO> selectBoards() {
		return mapper.selectBoards();
	}
	BoardDTO selectBoard(int id) {
		return  mapper.selectBoard(id);
	}
	int registerBoard(BoardDTO board) {
		//이렇게하면 방금넣은 아이디값이 board에 들어감.
		mapper.registerBoard(board);
		//이렇게 넣을걸 꺼내와야함
		int boardId = board.getId();
		List<FileDTO> fileList = board.getFileList();
		for (FileDTO file : fileList) {
			file.setBoardid(boardId);
		}
		//그걸 반복문 돌려서 찾아주고 그걸 insertFile(이안에 넣어야함.)
		
		//게시글을 등록한 뒤에 방금 등록된 게시글 번호를 가져와서
		//첨부파일 내용을 등록할때 함께 넣어줘야 함.
	
		return mapper.insertFile(fileList);
		//이렇게하면 insert할때 file이 리스트 형태로 바뀜.
	}
	int modifyBoard(BoardDTO board) {
		return mapper.modifyBoard(board);
	}
	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}
}
