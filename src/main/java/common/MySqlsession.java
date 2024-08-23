package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlsession {

	/*
	 *  MyBatis의 경우 처음에 시스템이 시작될 때
	 *  SqlSessionFactoryBuilder를 통해 SqlSessionFactory를 만들고
	 *  SqlSessionFactory를 통해 SqlSession 객체를 만든다음
	 *  SqlSession을 통해 데이터베이스 쿼리를 실행한다
	 *  즉 처음 시작 될때 한번만 생성해서 모든 위치에서 실행(접근) 가능하도록 설정해야된다 (전역화 시켜줘야함.)
	 *  static을 사용하면 이렇게 설정이 가능하다 . 
	 *  field,method 에 사용할수 있다.
	 *  static block은 처음에 클래스가 사용될때 호출한ㄷㅏ. 
	
	 * */
	public static SqlSessionFactory sqlSessionFactory;
	static {
		//톰캣을 실행하면 이부분을 먼저 실행함.
		String resouce = "/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resouce);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession(true);
//		 MyBatis는 등록,수정,삭제시 auto commit 이 비활성화 되어있음
//		 sqlSession 객체 생성시 옵션에 auto commit을 true로 활성화 해야 auto commit이 됨
	}
	
}
































