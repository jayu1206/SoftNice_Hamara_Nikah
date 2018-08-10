package com.softNice.nikah.maintenance;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.softNice.nikah.beans.dashboard;
import com.softNice.nikah.dao.dashboardDAO;
import com.softNice.nikah.impl.dashboardImpl;


public class dashboardMaintenance {
	
	static Logger log = Logger.getLogger(dashboardMaintenance.class.getName()); 
	
	 private static dashboardMaintenance adminObj;  
	 private dashboardMaintenance() {  }  
	
	 public static dashboardMaintenance getInstance() {    
       if (adminObj==null)  
     {  
       	adminObj=new  dashboardMaintenance();  
     }  
       	return adminObj;  
	 }

	public void getAllDashboardData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		dashboardDAO dao = new dashboardImpl();
		ArrayList<dashboard> list=dao.getDashboardData();
		request.getSession().setAttribute("dashboard", list);
		
	}  
	 
	 
	 
	 

}
