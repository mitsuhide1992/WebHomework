package com.ORM;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
public class Teacher extends AbstractTeacher implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String teacherNo, String teacherName, String idNo,
			String facultyName) {
		super(teacherNo, teacherName, idNo, facultyName);
	}

	/** full constructor */
	public Teacher(String teacherNo, String teacherName, String idNo,
			String facultyName, String email, String phoneNo) {
		super(teacherNo, teacherName, idNo, facultyName, email, phoneNo);
	}

}
