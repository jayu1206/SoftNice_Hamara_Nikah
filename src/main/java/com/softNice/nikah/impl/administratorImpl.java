/*******************************************************************************
 * -----------------------------------------------------------------------------
 * <br>
 * <p><b>Copyright (c) 2018 SoftNice Pvt. Ltd. All Rights Reserved.</b> 
 * <br>
 * <br>
 * This SOURCE CODE FILE, which has been provided by SoftNice as part
 * of SoftNice product for use ONLY by licensed users of the product,
 * includes CONFIDENTIAL and PROPRIETARY information of SoftNice Creations.
 * <br>
 * USE OF THIS SOFTWARE IS GOVERNED BY THE TERMS AND CONDITIONS
 * OF THE LICENSE STATEMENT AND LIMITED WARRANTY FURNISHED WITH
 * THE PRODUCT.<br>
 * <br>
 * </p>
 * -----------------------------------------------------------------------------
 * <br>
 * <br>
 * Modification History:
 * Date                         Developer           Description
 * -----------------------------------------------------------------------------                          
 * 20-July-2018               Jay Gagnani                Added                       
 *
 ***************************************************************************** */

package com.softNice.nikah.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;

import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.database.HibernateFactory;


public class administratorImpl implements administratorDAO{
	static Logger log = Logger.getLogger(administratorImpl.class.getName());
	
	public administratorImpl(){
		HibernateFactory.buildIfNeeded();
	}
	
	@Override
	public int checkDublicateName(roleBean bean) {
		// TODO Auto-generated method stub
		int flag= 0;
		long count = 0;
		Session session = null;
		try {
			session = HibernateFactory.openSession();

			Query query = session
					.createQuery("select count(*) from roleBean where  roleName=:roleName and status=1");
			query.setParameter("roleName", bean.getRoleName());
			count = (Long) query.uniqueResult();

			
			session.flush();
			
			if(count>0){
				flag = 1;
			}
		

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

		return flag;
	}

	@Override
	public int insertRole(roleBean bean) {
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
	public ArrayList<roleBean> getAllRole() {
		// TODO Auto-generated method stub
		
		Session session = null;

		ArrayList<roleBean> arrActivity = new ArrayList<roleBean>();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from roleBean where status=1");
			arrActivity = (ArrayList<roleBean>) query.list();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public roleBean getRoleBaseOnId(int id) {
		// TODO Auto-generated method stub
		Session session = null;

		roleBean arrActivity = new roleBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from roleBean where roleId=:roleId and status=1");
			query.setParameter("roleId", id);
			arrActivity = (roleBean) query.list().get(0);

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int updateRole(roleBean bean) {
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
	public ArrayList<permissionnamesBean> getAllPermissionName() {
		// TODO Auto-generated method stub
		Session session = null;

		ArrayList<permissionnamesBean> arrActivity = new ArrayList<permissionnamesBean>();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from permissionnamesBean ");
			arrActivity = (ArrayList<permissionnamesBean>) query.list();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int insertPermission(permissionBean bean) {
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
	public permissionBean checkExistingPermisstion(permissionBean bean) {
		// TODO Auto-generated method stub
		
		Session session = null;

		permissionBean arrActivity = new permissionBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from permissionBean where roleId=:roleId and permissionName=:permissionName");
			query.setParameter("roleId", bean.getRoleId());
			query.setParameter("permissionName", bean.getPermissionName());
			if(query.list().size()>0){
				arrActivity = (permissionBean) query.list().get(0);
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
	public permissionBean getExistingPermisstion(int id,permissionnamesBean bean) {
		// TODO Auto-generated method stub
		
		Session session = null;

		permissionBean arrActivity = new permissionBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from permissionBean where roleId=:roleId and permissionName=:permissionName");
			query.setParameter("roleId", id);
			query.setParameter("permissionName", bean.getName());
			if(query.list().size()>0){
				arrActivity = (permissionBean) query.list().get(0);
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
	public int updatePermission(permissionBean bean) {
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
	public ArrayList<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = null;

		ArrayList<UserBean> arrActivity = new ArrayList<UserBean>();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from UserBean where status=1");
			arrActivity = (ArrayList<UserBean>) query.list();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

}
