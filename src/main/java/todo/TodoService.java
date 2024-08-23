package todo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.MySqlsession;

public class TodoService {
	private static TodoService instance = new TodoService();
	private TodoMapper mapper;

	private TodoService() {
		SqlSession session = MySqlsession.getSqlSession();
		mapper = session.getMapper(TodoMapper.class);
	}

	public static TodoService getInstance() {
		return instance;
	}

	public List<TodoVO> selectTodoList() {

		return mapper.selectTodoList();
	}

	public TodoVO selectTodo(int serachTNo) {

		return mapper.selectTodo(serachTNo);
	}

	public int insertTodo(TodoVO todo) {
		// TodoDAO의 insertTodo()를 호출하고싶다.
//		new를 하는순간 다 힙에 올라감.
//		메서드에 선언된건 다 stack에 올라감. 기본친구들
//		객체는 다 heap에 올라감.

		return mapper.insertTodo(todo);

	}

	public int updateTodo(TodoVO todo) {

		return mapper.updateTodo(todo);
	}

	public int deleteTodo(int tNo) {

		return mapper.deleteTodo(tNo);
	}

	public TodoVO updateComplete(TodoVO todo) {

		mapper.updateComplete(todo);
		return mapper.selectComplete(todo.gettNo());
		// 업데이트를 한다 -> 조회한다. 서비스는 DAO에 있는 두가지 기능을 하나로 묶어줄수 있음
		// 위에 처럼 트랜잭션 단위로 하나로 묶여야함.
	}

}
