package com.struts.action;


import com.DAO.StudentDAO;
import com.DAO.TimetableDAO;
import com.ORM.Student;
import com.ORM.Timetable;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyStudentInfoAction extends ActionSupport {
	private String studentNo;
	private String studentName;
	private String identifyNo;
	private String classNo;
	private String studentEmail;
	private String studentPhoneNo;
	private Student loginStudent;
	public Student getLoginStudent() {
		return loginStudent;
	}
	public void setLoginStudent(Student loginStudent) {
		this.loginStudent = loginStudent;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}
	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}
	public String modifyStudentInfo(){
		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student(studentNo,studentName, identifyNo,classNo,studentEmail,studentPhoneNo);
		studentDAO.update(student);
		loginStudent = student;
	    return "update_student_success";
	}
}
