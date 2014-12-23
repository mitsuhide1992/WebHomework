package com.ORM;

/**
 * Timetable entity. @author MyEclipse Persistence Tools
 */
public class Timetable extends AbstractTimetable implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Timetable() {
	}

	/** minimal constructor */
	public Timetable(Integer id) {
		super(id);
	}

	/** full constructor */
	public Timetable(Integer id, String semesterNo, String teacherNo,
			String classNo, String classRoom, String courseName,
			String startWeek, String endWeek, String startTime, String endTime,
			String weekday) {
		super(id, semesterNo, teacherNo, classNo, classRoom, courseName,
				startWeek, endWeek, startTime, endTime, weekday);
	}
	
	public Timetable(String semesterNo, String teacherNo,
			String classNo, String classRoom, String courseName,
			String startWeek, String endWeek, String startTime, String endTime,
			String weekday) {
		super(semesterNo, teacherNo, classNo, classRoom, courseName,
				startWeek, endWeek, startTime, endTime, weekday);
	}
	
}
