package com.ORM;

/**
 * AbstractTeacher entity provides the base persistence definition of the
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeacher implements java.io.Serializable {

	// Fields

	private String teacherNo;
	private String teacherName;
	private String idNo;
	private String facultyName;
	private String email;
	private String phoneNo;

	// Constructors

	/** default constructor */
	public AbstractTeacher() {
	}

	/** minimal constructor */
	public AbstractTeacher(String teacherNo, String teacherName, String idNo,
			String facultyName) {
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.idNo = idNo;
		this.facultyName = facultyName;
	}

	/** full constructor */
	public AbstractTeacher(String teacherNo, String teacherName, String idNo,
			String facultyName, String email, String phoneNo) {
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.idNo = idNo;
		this.facultyName = facultyName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	// Property accessors

	public String getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getFacultyName() {
		return this.facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}