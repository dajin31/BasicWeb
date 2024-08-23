package comment;

import java.util.List;

public interface CommentMapper {
	//게시글에 해당하는 댓글 목록 get
	List<CommentDTO> selectComments(int boardId);
	//댓글 한개 가져오기(댓글 등록시 사용할 예정) get
	CommentDTO selectComment(int id);
	//댓글 등록하기 post
	int registerComment(CommentDTO comment);
	//댓글 수정하기 post
	int modifyComment(CommentDTO comment);
	//댓글 삭제하기 get
	int removeComment(int id);
	
	int insertComment(List<CommentDTO> comment);
}
