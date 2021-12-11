package org.school;

public class Students {
public void getStudentInfo(int id) {
System.out.println("student id:"+id);

}
public void getStudentInfo(String name) {
System.out.println("student name:"+name);

}
public void getStudentInfo(String email,long phonenumber) {
System.out.println("student email:"+email);
System.out.println("student phonenumber:"+phonenumber);

}
public static void main(String[] args) {
	Students std=new Students();
	std.getStudentInfo(5006);
	std.getStudentInfo("N sathish kumar");
	std.getStudentInfo("mrcute12@gmail.com", 8122422520l);
	
	
}
}
