package com.DAO;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ORM.Timetable;


/**
 * A data access object (DAO) providing persistence and search support for
 * Timetable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see DAO.Timetable
 * @author MyEclipse Persistence Tools
 */

public class TimetableDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TimetableDAO.class);
	// property constants
	public static final String SEMESTER_NO = "semesterNo";
	public static final String TEACHER_NO = "teacherNo";
	public static final String CLASS_NO = "classNo";
	public static final String CLASS_ROOM = "classRoom";
	public static final String COURSE_NAME = "courseName";
	public static final String START_WEEK = "startWeek";
	public static final String END_WEEK = "endWeek";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String WEEKDAY = "weekday";

	public void save(Timetable transientInstance) {
		log.debug("saving Timetable instance");
		Transaction ts = null;
		try {
			Session session = getSession();
			ts = session.beginTransaction();
			session.save(transientInstance);
			ts.commit();
			if(session.isOpen()){
				session.close();
			}
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Timetable persistentInstance) {
		log.debug("deleting Timetable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Timetable findById(java.lang.Integer id) {
		log.debug("getting Timetable instance with id: " + id);
		try {
			Timetable instance = (Timetable) getSession().get("DAO.Timetable",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Timetable instance) {
		log.debug("finding Timetable instance by example");
		try {
			List results = getSession().createCriteria("DAO.Timetable")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Timetable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Timetable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySemesterNo(Object semesterNo) {
		return findByProperty(SEMESTER_NO, semesterNo);
	}

	public List findByTeacherNo(Object teacherNo) {
		return findByProperty(TEACHER_NO, teacherNo);
	}

	public List findByClassNo(Object classNo) {
		return findByProperty(CLASS_NO, classNo);
	}

	public List findByClassRoom(Object classRoom) {
		return findByProperty(CLASS_ROOM, classRoom);
	}

	public List findByCourseName(Object courseName) {
		return findByProperty(COURSE_NAME, courseName);
	}

	public List findByStartWeek(Object startWeek) {
		return findByProperty(START_WEEK, startWeek);
	}

	public List findByEndWeek(Object endWeek) {
		return findByProperty(END_WEEK, endWeek);
	}

	public List findByStartTime(Object startTime) {
		return findByProperty(START_TIME, startTime);
	}

	public List findByEndTime(Object endTime) {
		return findByProperty(END_TIME, endTime);
	}

	public List findByWeekday(Object weekday) {
		return findByProperty(WEEKDAY, weekday);
	}

	public List findAll() {
		log.debug("finding all Timetable instances");
		try {
			String queryString = "from Timetable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Timetable merge(Timetable detachedInstance) {
		log.debug("merging Timetable instance");
		try {
			Timetable result = (Timetable) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Timetable instance) {
		log.debug("attaching dirty Timetable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Timetable instance) {
		log.debug("attaching clean Timetable instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update(Timetable instance) {
		log.debug("updating Timetable instance");
		Transaction ts = null;
		try {
			Session session = getSession();
			ts = session.beginTransaction();
			session.update(instance);
			ts.commit();
			if(session.isOpen()){
				session.close();
			}
			log.debug("update successful");
//			return "updatesuccess";
		} catch (RuntimeException re) {
			log.error("update failed", re);
//			return "updatefailed";
			throw re;
		}
	}
}