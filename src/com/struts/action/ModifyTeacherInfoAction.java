package com.struts.action;


import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;
import com.ORM.Student;
import com.ORM.Teacher;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyTeacherInfoAction extends ActionSupport {
	private String teacherNo;
	private String teacherName;
	private String identifyNo;
	private String facultyName;
	private String teacherEmail;
	private String teacherPhoneNo;
	private Teacher loginteacher;
	
	public Teacher getLoginteacher() {
		return loginteacher;
	}

	public void setLoginteacher(Teacher loginteacher) {
		this.loginteacher = loginteacher;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getIdentifyNo() {
		return identifyNo;
	}

	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherPhoneNo() {
		return teacherPhoneNo;
	}

	public void setTeacherPhoneNo(String teacherPhoneNo) {
		this.teacherPhoneNo = teacherPhoneNo;
	}

	public String modifyTeacherInfo(){
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = new Teacher(teacherNo,teacherName, identifyNo,facultyName,teacherEmail,teacherPhoneNo);
		teacherDAO.update(teacher);
		loginteacher = teacher;
	    return "update_teacher_success";
	}
}
