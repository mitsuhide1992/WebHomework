package com.ORM;

/**
 * AbstractTimetable entity provides the base persistence definition of the
 * Timetable entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTimetable implements java.io.Serializable {

	// Fields

	private Integer id;
	private String semesterNo;
	private String teacherNo;
	private String classNo;
	private String classRoom;
	private String courseName;
	private String startWeek;
	private String endWeek;
	private String startTime;
	private String endTime;
	private String weekday;

	// Constructors

	/** default constructor */
	public AbstractTimetable() {
	}

	/** minimal constructor */
	public AbstractTimetable(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractTimetable(Integer id, String semesterNo, String teacherNo,
			String classNo, String classRoom, String courseName,
			String startWeek, String endWeek, String startTime, String endTime,
			String weekday) {
		this.id = id;
		this.semesterNo = semesterNo;
		this.teacherNo = teacherNo;
		this.classNo = classNo;
		this.classRoom = classRoom;
		this.courseName = courseName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekday = weekday;
	}
	
	public AbstractTimetable(String semesterNo, String teacherNo,
			String classNo, String classRoom, String courseName,
			String startWeek, String endWeek, String startTime, String endTime,
			String weekday) {
		this.semesterNo = semesterNo;
		this.teacherNo = teacherNo;
		this.classNo = classNo;
		this.classRoom = classRoom;
		this.courseName = courseName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekday = weekday;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemesterNo() {
		return this.semesterNo;
	}

	public void setSemesterNo(String semesterNo) {
		this.semesterNo = semesterNo;
	}

	public String getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getClassNo() {
		return this.classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassRoom() {
		return this.classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStartWeek() {
		return this.startWeek;
	}

	public void setStartWeek(String startWeek) {
		this.startWeek = startWeek;
	}

	public String getEndWeek() {
		return this.endWeek;
	}

	public void setEndWeek(String endWeek) {
		this.endWeek = endWeek;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWeekday() {
		return this.weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

}