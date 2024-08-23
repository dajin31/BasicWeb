package common;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebListener
public class MybatisLoaderListener implements ServletContextListener {

    
    public MybatisLoaderListener() {
        // 생성자임
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // WAS가 종료될때 호출
    	System.out.println("서버 종료됨");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         // WAS가 시작될때 호출
    	System.out.println("서버 시작됨");
    	String resouce = "/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resouce);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//WAS가 종료되기 전까지 데이터가 살있는 applicationContext에 sqlsession을 저장하고
		//applicationContext에 저장된 데이터를 원하는 위치에서 사용할 수 있다.
		ServletContext context = sce.getServletContext();
		context.setAttribute("sqlSession", sqlSession);
		//여기에 저장하면 데이터가 서버가 종료될때까지 계속 살아있음.
		//설정한 mybatis값을 계속 사용해야되기때문에 이렇게 함.
		//이렇게 하면 was가 호출된걸 sqlsession에 저장한거임...
    }
	
}
