package com.softNice.nikah.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softNice.nikah.beans.memberBean;
import com.softNice.nikah.beans.memberDetailsBean;
import com.softNice.nikah.beans.memberPlanBean;
import com.softNice.nikah.beans.memberStoryBean;
import com.softNice.nikah.beans.orderBean;
import com.softNice.nikah.dao.memberDAO;
import com.softNice.nikah.database.HibernateFactory;

public class memberImpl implements memberDAO {
	static Logger log = Logger.getLogger(memberImpl.class.getName());
	
	@Override
	public ArrayList<memberPlanBean> getAllPlan() {
		// TODO Auto-generated method stub
		Session session = null;

		ArrayList<memberPlanBean> arrActivity = new ArrayList<memberPlanBean>();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberPlanBean where status=1 order by planCharges asc");
			arrActivity = (ArrayList<memberPlanBean>) query.list();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int insertMemberPlan(memberPlanBean bean) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.save(bean);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public memberPlanBean getMemberPlanById(int id) {
		// TODO Auto-generated method stub
		Session session = null;

		memberPlanBean arrActivity = new memberPlanBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberPlanBean where planId=:planId and status=1");
			query.setParameter("planId", id);
			arrActivity = (memberPlanBean) query.list().get(0);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int deleteMemberPlan(memberPlanBean bean) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.update(bean);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public memberBean loginMemberAuth(String userName, String password) {
		// TODO Auto-generated method stub
		Session session = null;

		memberBean arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberBean where (memberId=:memberId OR email=:email ) and password=:password  and status=1");
			query.setParameter("memberId", userName);
			query.setParameter("email", userName);
			query.setParameter("password", password);
			if(query.list().size()>0){
				arrActivity = new memberBean();
				arrActivity = (memberBean) query.list().get(0);
			}
			
			//arrActivity.setPassword(EncrypitDecrypit.decrypt(arrActivity.getPassword(), "password"));

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public boolean checkDublicateEmail(String str, int id) {
		// TODO Auto-generated method stub
		boolean flag= true;
		long count = 0;
		Session session = null;
		try {
			session = HibernateFactory.openSession();
			Query query= null;
			if(id != 0){
				query = session
						.createQuery("select count(*) from memberBean where  email=:email and status=1 and id!=:id");
				query.setParameter("id", id);
			}else{
				 query = session
							.createQuery("select count(*) from memberBean where  email=:email and status=1");
			}
				
			query.setParameter("email", str);
			count = (Long) query.uniqueResult();
			session.flush();
			
			if(count>0){
				flag = false;
			}
		

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			flag = true;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public memberPlanBean getFreeMembershipPlan() {
		// TODO Auto-generated method stub
		Session session = null;
		memberPlanBean arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberPlanBean where status=1 and planCharges=0  ");
			
			if(query.list().size()!=0){
				arrActivity = new memberPlanBean();
				arrActivity = (memberPlanBean) query.list().get(0);
			}
			

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int newRegisterMember(memberBean bean) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.save(bean);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public memberBean getMemberBaseOnId(int id) {
		// TODO Auto-generated method stub
		Session session = null;

		memberBean arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberBean where id=:id  and status=1");
			query.setParameter("id", id);
			if(query.list().size()>0){
				arrActivity = new memberBean();
				arrActivity = (memberBean) query.list().get(0);
			}
			
			//arrActivity.setPassword(EncrypitDecrypit.decrypt(arrActivity.getPassword(), "password"));

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int insertMemberDetails(memberDetailsBean details) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.save(details);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<memberBean> getAllMembers() {
		// TODO Auto-generated method stub
		Session session = null;

		ArrayList<memberBean> arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberBean ");
			if(query.list().size()>0){
				arrActivity = new ArrayList<memberBean>();
				arrActivity = (ArrayList<memberBean>) query.list();
			}
			

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}
	
	@Override
	public ArrayList<memberBean> getAllActiveMembers() {
		// TODO Auto-generated method stub
		Session session = null;

		ArrayList<memberBean> arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberBean where status=1 ");
			if(query.list().size()>0){
				arrActivity = new ArrayList<memberBean>();
				arrActivity = (ArrayList<memberBean>) query.list();
			}
			

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}
	
	@Override
	public boolean checkDublicatePhone(String str,int id) {
		// TODO Auto-generated method stub
		boolean flag= true;
		long count = 0;
		Session session = null;
		try {
			session = HibernateFactory.openSession();
			Query query= null;
			
			if(id != 0){
				query = session
						.createQuery("select count(*) from memberBean where  phno=:phno and status=1 and id!=:id");
				query.setParameter("id", id);
			}else{
				 query = session
						.createQuery("select count(*) from memberBean where  phno=:phno and status=1");
			}
			
			query.setParameter("phno", str);
			count = (Long) query.uniqueResult();
			session.flush();
			
			if(count>0){
				flag = false;
			}
		

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			flag = true;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public int updateMember(memberBean bean) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.update(bean);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
//	public int addMemberStory(memberStoryBean bean) {		

	public memberPlanBean getAllPlanByID(int planId) {
		// TODO Auto-generated method stub
		Session session = null;

		memberPlanBean arrActivity = new memberPlanBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberPlanBean where status=1 and planId=:planId ");
			query.setParameter("planId", planId);
			arrActivity = (memberPlanBean) query.list().get(0);

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public memberBean getMemberBaseOnMemberId(String memberId) {
		// TODO Auto-generated method stub
		Session session = null;

		memberBean arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from memberBean where memberId=:memberId  and status=1");
			query.setParameter("memberId", memberId);
			if(query.list().size()>0){
				arrActivity = new memberBean();
				arrActivity = (memberBean) query.list().get(0);
			}
			
			//arrActivity.setPassword(EncrypitDecrypit.decrypt(arrActivity.getPassword(), "password"));

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int insertOrder(orderBean bean) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.save(bean);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int addMemberStory(memberStoryBean bean) {

		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=HibernateFactory.openSession();
			session.save(bean);
			session.flush();
			return 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return 2;
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}

}
