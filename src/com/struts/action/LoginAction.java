package com.struts.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.DAO.StudentDAO;
import com.DAO.TeacherDAO;
import com.ORM.HibernateSessionFactory;
import com.ORM.Student;
import com.ORM.Teacher;
import com.ORM.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String loginUserNo;
	private String loginPassword;
	private Student loginStudent;
	private Teacher loginteacher;
	public Student getLoginStudent() {
		return loginStudent;
	}
	public Teacher getLoginteacher() {
		return loginteacher;
	}
	public void setLoginteacher(Teacher loginteacher) {
		this.loginteacher = loginteacher;
	}
	public void setLoginStudent(Student loginStudent) {
		this.loginStudent = loginStudent;
	}
	public String getLoginUserNo() {
		return loginUserNo;
	}
	public void setLoginUserNo(String loginUserNo) {
		this.loginUserNo = loginUserNo;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String checkUser() throws Exception{

		 Session session = null;
		 List result = null;
//		 List studentresult = null;
		 try {
            session = HibernateSessionFactory.getSession();
            
            session.beginTransaction();
            String sql = "select a.* from user a where a.userNo='"+loginUserNo+"' and a.password='"+loginPassword+"'";
    		result = session.createSQLQuery(sql).addEntity(User.class).list();
            session.beginTransaction().commit();
            if(session!=null){
                  session.close();
            }
		 } catch (RuntimeException e) {
            session.beginTransaction().rollback();
            if(session!=null){
                  session.close();
            }
            throw e;
	 	}
		 if(result.size() == 0){
			return "loginfailure";
		 }
		 else{
			User loginUser = (User)result.get(0);
			String loginType = loginUser.getUserType();
//			System.out.println(loginType);
			if(loginType.equals("student")){
				StudentDAO studentDAO = new StudentDAO();
				Student student = new Student();
				student = studentDAO.findById(loginUserNo);
				loginStudent = student;
				return "loginstudent";
			}
			else if(loginType.equals("teacher")){
				TeacherDAO teacherDAO = new TeacherDAO();
				Teacher teacher = new Teacher();
				teacher = teacherDAO.findById(loginUserNo);
				loginteacher = teacher;
				return "loginteacher";
			}
			else if(loginType.equals("admin")){
				return "loginadmin";
			}
			else{
				System.out.println("User Type Error!");
				return "loginfailure";
			}
		 }
	}
}