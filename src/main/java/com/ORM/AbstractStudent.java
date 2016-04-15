package com.ORM;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	private String studentNo;
	private String studentName;
	private String idNo;
	private String classNo;
	private String email;
	private String phoneNo;

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** minimal constructor */
	public AbstractStudent(String studentNo, String studentName, String idNo,
			String classNo) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.idNo = idNo;
		this.classNo = classNo;
	}

	/** full constructor */
	public AbstractStudent(String studentNo, String studentName, String idNo,
			String classNo, String email, String phoneNo) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.idNo = idNo;
		this.classNo = classNo;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	// Property accessors

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getClassNo() {
		return this.classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
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