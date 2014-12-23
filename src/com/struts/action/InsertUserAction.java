package com.struts.action;


import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;
import com.DAO.UserDAO;
import com.ORM.Student;
import com.ORM.Teacher;
import com.ORM.User;
import com.opensymphony.xwork2.ActionSupport;

public class InsertUserAction extends ActionSupport {
	private String userNo;
	private String userName;
	private String password;
	private String identifyNo;
	private String userEmail;
	private String phoneNo;
	private String userType;
	private String faculty;
	private String classNo;
	private String realUserType;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getRealUserType() {
		return realUserType;
	}
	public void setRealUserType(String realUserType) {
		this.realUserType = realUserType;
	}
	public String insertUser(){
		UserDAO userDAO = new UserDAO();
		User user = new User(userNo,userName,password,realUserType);
		userDAO.save(user);
		if(realUserType.equals("student")){
			StudentDAO studentDAO = new StudentDAO();
			Student student = new Student(userNo,userName,identifyNo,classNo,userEmail,phoneNo);
			studentDAO.save(student);
		}
		else if(realUserType.equals("teacher")){
			TeacherDAO teacherDAO = new TeacherDAO();
			Teacher teacher = new Teacher(userNo, userName,identifyNo,faculty,userEmail,phoneNo);
			teacherDAO.save(teacher);
		}
		return "insertsuccess";
	}
}
