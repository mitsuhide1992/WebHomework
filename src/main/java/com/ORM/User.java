package com.ORM;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userNo) {
		super(userNo);
	}

	/** full constructor */
	public User(String userNo, String userName, String password, String userType) {
		super(userNo, userName, password, userType);
	}

}
