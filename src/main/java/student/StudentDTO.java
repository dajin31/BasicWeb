package student;

public class StudentDTO {
 private String no;
 private String depart;
 private String name;
 private String address;
 private String phone;
 
public StudentDTO(String no, String depart, String name, String address, String phone) {
	super();
	this.no = no;
	this.depart = depart;
	this.name = name;
	this.address = address;
	this.phone = phone;
}

public String getNo() {
	return no;
}

public void setNo(String no) {
	this.no = no;
}

public String getDepart() {
	return depart;
}

public void setDepart(String depart) {
	this.depart = depart;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "StudentDTO [no=" + no + ", depart=" + depart + ", name=" + name + ", address=" + address + ", phone="
			+ phone + "]";
}
 


}
