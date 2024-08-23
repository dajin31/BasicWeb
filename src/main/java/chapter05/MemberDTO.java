package chapter05;

import java.time.LocalDate;
import java.util.Objects;

//우리나라 웹 개발에서는 DTO보다는 VO(Value Object)를 많이 사용
//자바에서는 필드를 private으로 선언해야함.
//외부에서 필드의 값을 마음대로 바꾸지 못하도록 private으로 선언하는걸 중요하게 생각함
//이것이 캡슐화임.
public class MemberDTO {
 private String memId;
 private String memPass;
 private String memName;
 private LocalDate memBir;
 private String memZip;
 private String memAdd1;
 private String memAdd2;
 private String memHp;
 private String memMail;
 
 
 
 
public MemberDTO(String memId, String memName, String memHp, String memMail) {
	super();
	this.memId = memId;
	this.memName = memName;
	this.memHp = memHp;
	this.memMail = memMail;
}

public MemberDTO(String memId, String memName, LocalDate memBir, String memZip, String memAdd1, String memAdd2,
		String memHp, String memMail) {
	this.memId = memId;
	this.memName = memName;
	this.memBir = memBir;
	this.memZip = memZip;
	this.memAdd1 = memAdd1;
	this.memAdd2 = memAdd2;
	this.memHp = memHp;
	this.memMail = memMail;
}

public MemberDTO(String memId, String memPass, String memName, LocalDate memBir, String memZip, String memAdd1,
		String memAdd2, String memHp, String memMail) {
	this.memId = memId;
	this.memPass = memPass;
	this.memName = memName;
	this.memBir = memBir;
	this.memZip = memZip;
	this.memAdd1 = memAdd1;
	this.memAdd2 = memAdd2;
	this.memHp = memHp;
	this.memMail = memMail;
}

public String getMemPass() {
	return memPass;
}

public void setMemPass(String memPass) {
	this.memPass = memPass;
}

public String getMemId() {
	return memId;
}
public void setMemId(String memId) {
	this.memId = memId;
}
public String getMemName() {
	return memName;
}
public void setMemName(String memName) {
	this.memName = memName;
}
public LocalDate getMemBir() {
	return memBir;
}
public void setMemBir(LocalDate memBir) {
	this.memBir = memBir;
}
public String getMemZip() {
	return memZip;
}
public void setMemZip(String memZip) {
	this.memZip = memZip;
}
public String getMemAdd1() {
	return memAdd1;
}
public void setMemAdd1(String memAdd1) {
	this.memAdd1 = memAdd1;
}
public String getMemAdd2() {
	return memAdd2;
}
public void setMemAdd2(String memAdd2) {
	this.memAdd2 = memAdd2;
}
public String getMemHp() {
	return memHp;
}
public void setMemHp(String memHp) {
	this.memHp = memHp;
}
public String getMemMail() {
	return memMail;
}
public void setMemMail(String memMail) {
	this.memMail = memMail;
}

@Override
public String toString() {
	return "MemberDTO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memBir=" + memBir
			+ ", memZip=" + memZip + ", memAdd1=" + memAdd1 + ", memAdd2=" + memAdd2 + ", memHp=" + memHp + ", memMail="
			+ memMail + "]";
}

 
 
 //생성자
//public MemberDTO(String memId, String memName, String memHp, String memMail) {
//	super();
//	this.memId = memId;
//	this.memName = memName;
//	this.memHp = memHp;
//	this.memMail = memMail;
//}

//getter and setter
//public String getMemId() {
//	return memId;
//}
//public void setMemId(String memId) {
//	this.memId = memId;
//}
//public String getMemName() {
//	return memName;
//}
//public void setMemName(String memName) {
//	this.memName = memName;
//}
//public String getMemHp() {
//	return memHp;
//}
//public void setMemHp(String memHp) {
//	this.memHp = memHp;
//}
//public String getMemMail() {
//	return memMail;
//}
//public void setMemMail(String memMail) {
//	this.memMail = memMail;
//}

//toString()
//@Override
//public String toString() {
//	return "MemberDTO [memId=" + memId + ", memName=" + memName + ", memHp=" + memHp + ", memMail=" + memMail + "]";
//}

//equals()and hashCode()




}
