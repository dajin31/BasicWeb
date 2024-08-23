package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
//	필터안에는 추상 메서드가 있음

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		dofilter가 필터의 역할을 실행함.
//		req -> 요청 resp -> 응답 chain -> 필터가 여러개 있을때 연결되서 실행. 순서에 따라 실행됨.
//		1.서블릿 실행전 코드
		req.setCharacterEncoding("utf-8");
		chain.doFilter(req, resp);
//		↑ 이게 있어야 실행이 됨 체인의 다음 필터처리
//		2.체인의 다음 필터처리
// 		사용자가 요청하면 그때 요청에 대한 필터가 처리되는데 그걸 dofilter가 처리함.
//		연결된 필터가 더이상 없으면 원래 요청을 처리하는 서블릿 실행
//		디자인패턴 : 프록시 패턴이라고 함. dofilter가 doget. dopost를 대신실행해줌
//		invoke도 메서드 호출하는것임.
//		call과 invoke 차이
//		call은 주로 개발자가 코드를 작성해서 호출하는것
//		invoke는 프로그램에 의해서 호출되는것
		
		
	}
}
