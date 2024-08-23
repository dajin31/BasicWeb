package login;

import org.apache.ibatis.session.SqlSession;

import chapter05.MemberDTO;
import common.MySqlsession;

public class LoginService {
	private static LoginMapper mapper;
	private static LoginService instance = new LoginService();
	
	private LoginService() {
		SqlSession session = MySqlsession.getSqlSession();
		mapper = session.getMapper(LoginMapper.class);
	}
	
	public static LoginService getInstance(SqlSession session) {
		mapper = session.getMapper(LoginMapper.class);
		return instance;
	}
	
	public MemberDTO findMemberById(String id,String password) {
		MemberDTO member = mapper.findMemberById(id);
		if(member.getMemPass().equals(password)) {
			return member;
		}
		return null;
//		로그인 처리 방식의 변화
//		초창기 : 아이디 비번이 일치하는 사용자 존재여부
//		최근 : 아이디로 사용자 정볼르 가져온 뒤 비밀번호 비교
//		비밀번호 일치하면 로그인
//		보안이 취약해서 바뀜
//		해쉬는 한번 바꾸면 복원 불가
	}
}
