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

package com.softNice.nikah.listner;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;
import com.softNice.nikah.maintenance.settingMaintenance;





public class listenerClass implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext context = event.getServletContext();
		
		administratorDAO dao=new administratorImpl();
		ArrayList<permissionnamesBean> permissionNameList= dao.getAllPermissionName();
		context.setAttribute(contentPage.PERMISSIONNAME, permissionNameList);
		settingBean bean= settingMaintenance.getInstance().getSetting("general_setting", null);
		context.setAttribute(contentPage.SETTING,bean);
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"Religion");
		map.put(2,"Culture");
		map.put(3,"Education"); 
		map.put(4,"Profession");
		map.put(5,"Income"); 
		map.put(6,"Height");
		map.put(7,"Weight"); 
		map.put(8,"Built"); 
		map.put(9,"Complexion");
		map.put(10,"Diet");
		map.put(11,"Drink"); 
		map.put(12,"Smoke"); 
		
		context.setAttribute(contentPage.MASTERMAPOBJ, map);
		
		
	}

}
