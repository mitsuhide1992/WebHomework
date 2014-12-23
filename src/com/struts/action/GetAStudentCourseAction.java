package com.struts.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ORM.Student;
import com.ORM.Timetable;
import com.opensymphony.xwork2.ActionSupport;

public class GetAStudentCourseAction extends ActionSupport {
	private String studentCourse;
	private String classNo;
	
	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getAStudentCourse(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		List result = null;
		String sql = "select a.* from timeTable a where a.classNo like '%&"+classNo+"&%'";
		result = session.createSQLQuery(sql).addEntity(Timetable.class).list();
		
//		Timetable tt = (Timetable)result.get(0);
//		String tteacher = tt.getTeacherNo();
		
//		JSONObject jsonResult = JSONObject.fromObject(result);
		 JSONArray jsonResult = JSONArray.fromObject(result);  
//		System.out.println("ININININININI");
		 studentCourse = jsonResult.toString();
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
		return SUCCESS;
	}
}
