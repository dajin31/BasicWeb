package memo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
	public List<MemoVO> selectMemoList() {
		List<MemoVO> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			String sql = """
						select
						  m_no,
						  title,
						  content,
						  writer,
						  register_date,
						  modified_date
						 from
						 	memo
					""";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int mNo = resultSet.getInt("m_no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				LocalDate registerDate = resultSet.getDate("register_date").toLocalDate();
				LocalDate modifiedDate = resultSet.getDate("modified_date") == null ? null
						: resultSet.getDate("modified_date").toLocalDate();
				list.add(new MemoVO(mNo, title, content, writer, registerDate, modifiedDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	}

	public MemoVO selectMemo(int searchMNo) {
		MemoVO vo = null;

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			String sql = """
						select
						  	m_no,
						  	title,
						  	content,
						  	writer,
						  	register_date,
						  	modified_date
						 from
						 	memo
						 where
						 	m_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, searchMNo);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int mNo = resultSet.getInt("m_no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				LocalDate registerDate = resultSet.getDate("register_date").toLocalDate();
				LocalDate modifiedDate = resultSet.getDate("modified_date") == null ? null
						: resultSet.getDate("modified_date").toLocalDate();
				;
				vo = new MemoVO(mNo, title, content, writer, registerDate, modifiedDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return vo;
	}

	public int insertMemo(MemoVO memo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			String sql = """
						insert into memo
						(title,content,writer)
						values
						(?,?,?)
					""";
			statement = connection.prepareStatement(sql);
			statement.setString(1, memo.getTitle());
			statement.setString(2, memo.getContent());
			statement.setString(3, memo.getWriter());

			executeUpdate = statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return executeUpdate;
	}

	public int updateMemo(MemoVO memo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			String sql = """
						update
							memo
						set
							title = ?,
							content = ? ,
							writer = ?
						where
							m_no = ?
					""";

			statement = connection.prepareStatement(sql);
			statement.setString(1, memo.getTitle());
			statement.setString(2, memo.getContent());
			statement.setString(3, memo.getWriter());
			statement.setInt(4, memo.getmNo());

			executeUpdate = statement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return executeUpdate;
	}

	public int deleteMemo(int mNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		int executeUpdate=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@nextit.or.kr:1521:xe", "std202", "oracle21c");
			String sql = """
					delete from
						memo
					where
						m_no = ?
					""";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, mNo);
			executeUpdate = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		return executeUpdate;
	}

}
