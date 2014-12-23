package com.struts.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.DAO.StudentDAO;
import com.DAO.TimetableDAO;
import com.ORM.Student;
import com.ORM.Timetable;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteTimeTableAction extends ActionSupport {
	private int timeTableI;
	public int getTimeTableI() {
		return timeTableI;
	}
	public void setTimeTableI(int timeTableI) {
		this.timeTableI = timeTableI;
	}
	public String deleteTimetable(){
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		String sql = "delete from timeTable where id="+timeTableI+"";
		System.out.println(sql);
		session.createSQLQuery(sql).executeUpdate();
		
		session.getTransaction().commit();
		if(session.isOpen()){
			session.close();
		}
		return "delete_timetable_success";
	}
}
