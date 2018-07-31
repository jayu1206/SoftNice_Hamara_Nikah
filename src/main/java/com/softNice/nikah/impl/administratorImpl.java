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
import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.database.HibernateFactory;
import com.softNice.nikah.utility.EncrypitDecrypit;


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

	@Override
	public ArrayList<countryBean> getAllCountry() {
		// TODO Auto-generated method stub
		Session session = null;

		ArrayList<countryBean> arrActivity = new ArrayList<countryBean>();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from countryBean where status=1");
			arrActivity = (ArrayList<countryBean>) query.list();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public boolean checkDublicateUserName(String str,int id) {
		// TODO Auto-generated method stub
		boolean flag= true;
		long count = 0;
		Session session = null;
		try {
			session = HibernateFactory.openSession();
			Query query = null;
			if(id != 0){
				query = session
						.createQuery("select count(*) from UserBean where  userName=:userName and status=1 and id!=:id");
				query.setParameter("id", id);
			}else{
				query = session
						.createQuery("select count(*) from UserBean where  userName=:userName and status=1");
			}
			query.setParameter("userName", str);
			
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
	public boolean checkDublicateEmail(String str,int id) {
		// TODO Auto-generated method stub
		boolean flag= true;
		long count = 0;
		Session session = null;
		try {
			session = HibernateFactory.openSession();
			Query query= null;
			if(id != 0){
				query = session
						.createQuery("select count(*) from UserBean where  email=:email and status=1 and id!=:id");
				query.setParameter("id", id);
			}else{
				 query = session
							.createQuery("select count(*) from UserBean where  email=:email and status=1");
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
						.createQuery("select count(*) from UserBean where  phno=:phno and status=1 and id!=:id");
				query.setParameter("id", id);
			}else{
				 query = session
						.createQuery("select count(*) from UserBean where  phno=:phno and status=1");
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
	public int insertUser(UserBean bean) {
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
	public UserBean getUserbyId(int id) {
		// TODO Auto-generated method stub
		Session session = null;

		UserBean arrActivity = new UserBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from UserBean where id=:id and status=1");
			query.setParameter("id", id);
			arrActivity = (UserBean) query.list().get(0);
			arrActivity.setPassword(EncrypitDecrypit.decrypt(arrActivity.getPassword(), "password"));

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int updateUser(UserBean bean) {
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
	public UserBean loginUserAuth(String userName, String password) {
		// TODO Auto-generated method stub
		Session session = null;

		UserBean arrActivity = null;
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from UserBean where userName=:userName and password=:password  and status=1");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			if(query.list().size()>0){
				arrActivity = new UserBean();
				arrActivity = (UserBean) query.list().get(0);
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
	public settingBean getSetting(String string) {
		// TODO Auto-generated method stub
		Session session = null;

		settingBean arrActivity = new settingBean();
		try {

			session = HibernateFactory.openSession();

			Query query = session.createQuery(" from settingBean where type=:type ");
			query.setParameter("type", string);
			arrActivity = (settingBean) query.list().get(0);
			

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			 e.printStackTrace();
		} finally {
			HibernateFactory.close(session);
		}

		return arrActivity;
	}

	@Override
	public int updateSetting(settingBean bean) {
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

}
