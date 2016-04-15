package com.struts.action;

import java.util.List;
import java.lang.Integer;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;
import com.DAO.TimetableDAO;
import com.DAO.UserDAO;
import com.ORM.Student;
import com.ORM.Teacher;
import com.ORM.Timetable;
import com.ORM.User;
import com.opensymphony.xwork2.ActionSupport;

public class InsertTimetableAction extends ActionSupport {
	private String newCourseN;
	private String newSemesterN;
	private String newTeacherN;
	private String newClassN;
	private String newClassR;
	private String newStartW;
	private String newEndW;
	private String newStartT;
	private String newEndT;
	private String newWeekD;
	private String newRealWeekD;
	public String insertTimetable(){
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		String sql = "insert into timeTable (semesterNo,teacherNo,classNo,classRoom,courseName,startWeek,endWeek,startTime,endTime,weekday) " +
				"values ('"+newSemesterN+"','"+newTeacherN+"','"+newClassN+"','"+newClassR+"','"+newCourseN+"','"+newStartW+"','"+newEndW+"','"+newStartT+"','"+newEndT+"','"+newRealWeekD+"')";
		System.out.println(sql);
		session.createSQLQuery(sql).executeUpdate();
		
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
		
		return "insert_timetable_success";
	}
	public String getNewCourseN() {
		return newCourseN;
	}
	public void setNewCourseN(String newCourseN) {
		this.newCourseN = newCourseN;
	}
	public String getNewSemesterN() {
		return newSemesterN;
	}
	public void setNewSemesterN(String newSemesterN) {
		this.newSemesterN = newSemesterN;
	}
	public String getNewTeacherN() {
		return newTeacherN;
	}
	public void setNewTeacherN(String newTeacherN) {
		this.newTeacherN = newTeacherN;
	}
	public String getNewClassN() {
		return newClassN;
	}
	public void setNewClassN(String newClassN) {
		this.newClassN = newClassN;
	}
	public String getNewClassR() {
		return newClassR;
	}
	public void setNewClassR(String newClassR) {
		this.newClassR = newClassR;
	}
	public String getNewStartW() {
		return newStartW;
	}
	public void setNewStartW(String newStartW) {
		this.newStartW = newStartW;
	}
	public String getNewEndW() {
		return newEndW;
	}
	public void setNewEndW(String newEndW) {
		this.newEndW = newEndW;
	}
	public String getNewStartT() {
		return newStartT;
	}
	public void setNewStartT(String newStartT) {
		this.newStartT = newStartT;
	}
	public String getNewEndT() {
		return newEndT;
	}
	public void setNewEndT(String newEndT) {
		this.newEndT = newEndT;
	}
	public String getNewWeekD() {
		return newWeekD;
	}
	public void setNewWeekD(String newWeekD) {
		this.newWeekD = newWeekD;
	}
	public String getNewRealWeekD() {
		return newRealWeekD;
	}
	public void setNewRealWeekD(String newRealWeekD) {
		this.newRealWeekD = newRealWeekD;
	}
	
}
