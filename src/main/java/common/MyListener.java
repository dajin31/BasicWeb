package common;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//세션에 데이터 추가됨
	}
	public void attributeRemovd() {
		
	}
}
