package com.DAO;

import org.hibernate.Session;

import com.ORM.HibernateSessionFactory;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
}