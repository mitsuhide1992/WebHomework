package com.ORM;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentNo, String studentName, String idNo,
			String classNo) {
		super(studentNo, studentName, idNo, classNo);
	}

	/** full constructor */
	public Student(String studentNo, String studentName, String idNo,
			String classNo, String email, String phoneNo) {
		super(studentNo, studentName, idNo, classNo, email, phoneNo);
	}

}
