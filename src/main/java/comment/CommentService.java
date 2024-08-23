package comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlsession;

public class CommentService {
	private static CommentService instance = new CommentService();
	private static CommentMapper mapper;
	
	private CommentService() {
	}
	
	public static CommentService getInstance(SqlSession session) {
		mapper = session.getMapper(CommentMapper.class);
		return instance;
	}
	
	List<CommentDTO> selectComments(int boardId){
		return mapper.selectComments(boardId);
	}
	
	CommentDTO selectComment(int id) {
		return mapper.selectComment(id);
	}
	
	public CommentDTO registerComment(CommentDTO comment) {
		mapper.registerComment(comment);
		return mapper.selectComment(comment.getId());
	}
	int modifyComment(CommentDTO comment) {
		return mapper.modifyComment(comment);
	}
	int removeComment(int id) {
		return mapper.removeComment(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
