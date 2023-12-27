package ap;

public class Student {
 private int sid;
 private String name;
 private int fees;
 private String subject;
 private String address;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", name=" + name + ", fees=" + fees + ", subject=" + subject + ", address=" + address
			+ "]";
}
 

}
