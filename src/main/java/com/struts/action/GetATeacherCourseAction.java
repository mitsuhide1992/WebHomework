package com.struts.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ORM.Timetable;
import com.opensymphony.xwork2.ActionSupport;

public class GetATeacherCourseAction extends ActionSupport {
	private String teacherCourse;
	private String teacherNo;
	
	public String getATeacherCourse(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		List result = null;
		String sql = "select a.* from timeTable a where a.teacherNo ='"+teacherNo+"'";
		result = session.createSQLQuery(sql).addEntity(Timetable.class).list();
		
//		Timetable tt = (Timetable)result.get(0);
//		String tteacher = tt.getTeacherNo();
		
//		JSONObject jsonResult = JSONObject.fromObject(result);
		 JSONArray jsonResult = JSONArray.fromObject(result);  
//		System.out.println("ININININININI");
		 teacherCourse = jsonResult.toString();
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
		return SUCCESS;
	}


	public String getTeacherCourse() {
		return teacherCourse;
	}


	public void setTeacherCourse(String teacherCourse) {
		this.teacherCourse = teacherCourse;
	}


	public String getTeacherNo() {
		return teacherNo;
	}


	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
}
