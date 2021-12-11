package org.student;

public class Student extends org.department.Department {
public void studentName() {
	System.out.println("N sathish kumar");

}
public  void studentdept() {
	System.out.println("EEE");

}
public void studentId() {
	System.out.println("Id=5006");

}
public static void main(String[] args) {
	Student s1 = new Student();
	s1.collegeCode();
	s1.collegeName();
	s1.collegeRank();
	s1.deptName();
	s1.studentdept();
	s1.studentId();
	s1.studentName();
}


}
