package com.softNice.nikah.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softNice.nikah.beans.dashboard;
import com.softNice.nikah.dao.dashboardDAO;
import com.softNice.nikah.database.HibernateFactory;

public class dashboardImpl implements dashboardDAO {
	
	static Logger log = Logger.getLogger(dashboardImpl.class.getName());
	
	public dashboardImpl(){
		HibernateFactory.buildIfNeeded();
	}
	

	@Override
	public ArrayList<dashboard> getDashboardData() {
		// TODO Auto-generated method stub
		int flag= 0;
		long count = 0;
		Session session = null;
		ArrayList<dashboard> list = new ArrayList<dashboard>();
		dashboard bean=null;
		try {
			session = HibernateFactory.openSession();

			Query query = session.createQuery("select count(*) from memberBean ");
			count = (Long) query.uniqueResult();
			session.flush();
			
			bean = new dashboard();
			bean.setName("totalMembers");
			bean.setValue((int)count);
			list.add(bean);
			
			query = session.createQuery("select count(*) from memberBean where status=1 ");
			count = (Long) query.uniqueResult();
			session.flush();
			bean = new dashboard();
			bean.setName("active");
			bean.setValue((int)count);
			list.add(bean);
			/*  total gender   */
			bean = new dashboard();
			bean.setName("totalGender");
			bean.setValue((int)count);
			list.add(bean);
			
			
			
			query = session.createQuery("select count(*) from memberBean where status=0 ");
			count = (Long) query.uniqueResult();
			session.flush();
			bean = new dashboard();
			bean.setName("inactive");
			bean.setValue((int)count);
			list.add(bean);
			
			query = session.createQuery("select count(*) from memberBean where status=1 and gender=:gender ");
			query.setParameter("gender", "male");
			count = (Long) query.uniqueResult();
			session.flush();
			bean = new dashboard();
			bean.setName("male");
			bean.setValue((int)count);
			list.add(bean);
			
			query = session.createQuery("select count(*) from memberBean where status=1 and gender=:gender ");
			query.setParameter("gender", "female");
			count = (Long) query.uniqueResult();
			session.flush();
			bean = new dashboard();
			bean.setName("female");
			bean.setValue((int)count);
			list.add(bean);
			
			
			

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			flag = 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
