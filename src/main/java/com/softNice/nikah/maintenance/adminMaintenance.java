package com.softNice.nikah.maintenance;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;

public class adminMaintenance {
	
	static Logger log = Logger.getLogger(adminMaintenance.class.getName()); 
	
	 private static adminMaintenance adminObj;  
	 private adminMaintenance() {  }  
	
	 public static adminMaintenance getInstance() {    
        if (adminObj==null)  
      {  
        	adminObj=new  adminMaintenance();  
      }  
        	return adminObj;  
	 }  
	 
	 
	 public ArrayList<UserBean> getAllUsers(HttpServletRequest request) {
			// TODO Auto-generated method stub
			administratorDAO dao=new administratorImpl();
			ArrayList<UserBean> list=dao.getAllUsers();
			request.setAttribute("localObj", list);
			return list;
			
		}

}
