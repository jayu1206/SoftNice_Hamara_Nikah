package com.softNice.nikah.maintenance;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.softNice.nikah.beans.emailSetting;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;


public class settingMaintenance {
	
	static Logger log = Logger.getLogger(settingMaintenance.class.getName()); 
	
	 private static settingMaintenance settingObj;  
	 private settingMaintenance() {  }  
	
	 public static settingMaintenance getInstance() {    
       if (settingObj==null)  
     {  
    	   settingObj=new  settingMaintenance();  
     }  
       	return settingObj;  
	 }

	 public settingBean getSetting(String type,HttpServletRequest request){
		 administratorDAO dao= new administratorImpl();
		 settingBean bean = dao.getSetting("email_setting");
		 request.setAttribute("settingObj", bean);
		 return bean;
	 }
	 
	public ErrorMsg updateEmail(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao= new administratorImpl();
		ObjectMapper mapperObj = new ObjectMapper();
		settingBean bean = dao.getSetting("email_setting");
		emailSetting maileBean=new emailSetting();
		if(bean.getValue()!=null){
			maileBean = new Gson().fromJson(bean.getValue(),emailSetting.class);
		}
		
		maileBean.setEmail_type(request.getParameter("txtEmailType"));
		maileBean.setServer_name(request.getParameter("txtServerName"));
		maileBean.setUserName(request.getParameter("txtUserName"));
		maileBean.setPassword(request.getParameter("txtPassword"));
		maileBean.setPort(request.getParameter("txtPort"));
		
		try {
			
			bean.setValue(mapperObj.writeValueAsString(maileBean));
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int flag = dao.updateSetting(bean);
		
		if(flag!=0){
			return new ErrorMsg(0, "Email setting updated failed");
		}else{
			bean = getSetting("email_setting", request);
		}
		
		return new ErrorMsg(0, "Email setting updated sucessfully");
		
		
	}  

}
