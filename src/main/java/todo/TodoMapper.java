package todo;

import java.util.List;

public interface TodoMapper {
	 List<TodoVO> selectTodoList();
	 TodoVO selectTodo(int searchTNo);
	 int insertTodo(TodoVO todo);
	 int updateTodo(TodoVO todo);
	 int deleteTodo(int tNo);
	 int updateComplete(TodoVO todo);
	 TodoVO selectComplete(int tNo);
	 //이게 todo-mapper 에있는 아이들이랑 이름이랑 타입이 동일해야함.
	
	 
}
