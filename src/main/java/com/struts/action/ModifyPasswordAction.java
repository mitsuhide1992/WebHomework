package com.struts.action;


import com.DAO.StudentDAO;
import com.DAO.UserDAO;
import com.ORM.Student;
import com.ORM.User;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyPasswordAction extends ActionSupport {
	private String userNoForModify;
	private String newPassword;
	public String getUserNoForModify() {
		return userNoForModify;
	}
	public void setUserNoForModify(String userNoForModify) {
		this.userNoForModify = userNoForModify;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String modifyPassword(){
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(userNoForModify);
		if(user!=null){
			user.setPassword(newPassword);
			userDAO.update(user);
		}
		return "modify_password_success";
	}
}
