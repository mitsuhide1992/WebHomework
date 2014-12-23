package com.struts.action;


import com.DAO.TimetableDAO;
import com.ORM.Timetable;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyTimeTableAction extends ActionSupport {
	private String teacherN;
	private String semesterN;
	private String courseN;
	private String classN;
	private String classR;
	private String realWeekD;
	private String startW;
	private String endW;
	private String startT;
	private String endT;
	private int timeTableI;
	
	public String getTeacherN() {
		return teacherN;
	}
	public void setTeacherN(String teacherN) {
		this.teacherN = teacherN;
	}
	public String getSemesterN() {
		return semesterN;
	}
	public void setSemesterN(String semesterN) {
		this.semesterN = semesterN;
	}
	public String getCourseN() {
		return courseN;
	}
	public void setCourseN(String courseN) {
		this.courseN = courseN;
	}
	public String getClassN() {
		return classN;
	}
	public void setClassN(String classN) {
		this.classN = classN;
	}
	public String getClassR() {
		return classR;
	}
	public void setClassR(String classR) {
		this.classR = classR;
	}
	public String getRealWeekD() {
		return realWeekD;
	}
	public void setRealWeekD(String realWeekD) {
		this.realWeekD = realWeekD;
	}
	public String getStartW() {
		return startW;
	}
	public void setStartW(String startW) {
		this.startW = startW;
	}
	public String getEndW() {
		return endW;
	}
	public void setEndW(String endW) {
		this.endW = endW;
	}
	public String getStartT() {
		return startT;
	}
	public void setStartT(String startT) {
		this.startT = startT;
	}
	public String getEndT() {
		return endT;
	}
	public void setEndT(String endT) {
		this.endT = endT;
	}
	public int getTimeTableI() {
		return timeTableI;
	}
	public void setTimeTableI(int timeTableI) {
		this.timeTableI = timeTableI;
	}
	public String modifyTimeTable(){
		TimetableDAO timetableDAO = new TimetableDAO();
		Timetable timeTable = new Timetable(timeTableI,semesterN,teacherN,classN,classR,courseN,startW,endW,startT,endT,realWeekD);
	    timetableDAO.update(timeTable);
	    return "updatesuccess";
	}
}
