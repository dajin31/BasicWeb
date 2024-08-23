package todo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import chapter05.MemberDTO;
import common.MySqlsession;

public class TodoDAO {
	private SqlSession session = MySqlsession.getSqlSession();
	private static TodoDAO instance = new TodoDAO();

	// 메소드를 호출하는 용도로 객체를 생성하는건 하나만 하는게 좋음
	// 그래서 싱글톤패턴을 사용하는게 좋음 ㅇㅇ
	// 자바는 필트를 private하는게 많음 캡슐화
	// 그리고 static을 붙여서 외부에서 사용할수잇도록함.
	private TodoDAO() {

		// 생성자 : 외부에서 객체를 생성할때 호출하는 메소드
	}

	public static TodoDAO getInstance() {
		return instance;
	}

	public List<TodoVO> selectTodoList() {
		return session.selectList("todo.TodoMapper.selectTodoList");

	}

	public TodoVO selectTodo(int searchTNo) {
		return session.selectOne("todo.TodoMapper.selectTodo", searchTNo);

	}

	public int insertTodo(TodoVO todo) {

		int insert = session.insert("todo.TodoMapper.insertTodo", todo);
		return insert;
	}

	public int updateTodo(TodoVO todo) {
		int update = session.update("todo.TodoMapper.updateTodo", todo);
		return update;
	}

	public int deleteTodo(int tNo) {
		int delete = session.delete("todo.TodoMapper.deleteTodo", tNo);
		return delete;
	}

	public int updateComplete(TodoVO todo) {
		int update = session.update("todo.TodoMapper.updateCom", todo);
		return update;

	}

	public TodoVO selectComplete(int tNo) {
		return session.selectOne("todo.TodoMapper.selectCom", tNo);
	}
}
