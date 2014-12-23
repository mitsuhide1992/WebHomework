package com.struts.action;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ORM.Timetable;
import com.ORM.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetTimeTableAction extends ActionSupport {
	private String teacherNo;
	private String userNo;
	private String returnResult;
	private String selectResult;
	
	public String getSelectResult() {
		return selectResult;
	}

	public void setSelectResult(String selectResult) {
		this.selectResult = selectResult;
	}
	private String selectCourseN;
	private String selectSemesterN;
	private String selectTeacherN;
	private String selectClassN;
	private String selectClassR;
	
	public String getSelectCourseN() {
		return selectCourseN;
	}
	
	public void setSelectCourseN(String selectCourseN) {
		this.selectCourseN = selectCourseN;
	}
	
	public String getSelectSemesterN() {
		return selectSemesterN;
	}

	public void setSelectSemesterN(String selectSemesterN) {
		this.selectSemesterN = selectSemesterN;
	}

	public String getSelectTeacherN() {
		return selectTeacherN;
	}

	public void setSelectTeacherN(String selectTeacherN) {
		this.selectTeacherN = selectTeacherN;
	}

	public String getSelectClassN() {
		return selectClassN;
	}

	public void setSelectClassN(String selectClassN) {
		this.selectClassN = selectClassN;
	}

	public String getSelectClassR() {
		return selectClassR;
	}

	public void setSelectClassR(String selectClassR) {
		this.selectClassR = selectClassR;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(String returnResult) {
		this.returnResult = returnResult;
	}

	public String getAllTimeTable(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		List result = null;
		String sql = "select a.* from timeTable a";
		result = session.createSQLQuery(sql).addEntity(Timetable.class).list();
		
//		Timetable tt = (Timetable)result.get(0);
//		String tteacher = tt.getTeacherNo();
		
//		JSONObject jsonResult = JSONObject.fromObject(result);
		 JSONArray jsonResult = JSONArray.fromObject(result);  
//		System.out.println("ININININININI");
		returnResult = jsonResult.toString();
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
	
		return SUCCESS;
	}
	public String selectTimetable(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		List result = null;
		String sql = "select a.* from timeTable a ";
		boolean you = false;
		
		if(!selectCourseN.equals("")){
			sql+="where a.courseName='"+selectCourseN+"'";
			you = true;
		}
		if(!selectSemesterN.equals("")){
			if(you == true)
				sql+=" and a.semesterNo='"+selectSemesterN+"'";
			else{
				sql+="where a.semesterNo='"+selectSemesterN+"'";
				you = true;
			}
		}
		if(!selectTeacherN.equals("")){
			if(you)
				sql+=" and a.teacherNo='"+selectTeacherN+"'";
			else{
				sql+="where a.teacherNo='"+selectTeacherN+"'";
				you = true;
			}
		}
		if(!selectClassN.equals("")){
			if(you)
				sql+=" and a.classNo like '%"+selectClassN+"%'";
			else{
				sql+="where a.classNo like '%"+selectClassN+"%'";
				you = true;
			}
		}
		if(!selectClassR.equals("")){
			if(you)
				sql+=" and a.classRoom='"+selectClassR+"'";
			else{
				sql+="where a.classRoom='"+selectClassR+"'";
				you = true;
			}
		}
		result = session.createSQLQuery(sql).addEntity(Timetable.class).list();
		JSONArray jsonResult = JSONArray.fromObject(result);  
		selectResult = jsonResult.toString();
		System.out.println(selectResult);
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
		return SUCCESS;
	}
}
