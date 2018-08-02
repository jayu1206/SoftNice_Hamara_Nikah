package com.softNice.nikah.maintenance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.emailSetting;
import com.softNice.nikah.beans.generalSettingBean;
import com.softNice.nikah.beans.masterBean;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;
import com.softNice.nikah.utility.EncrypitDecrypit;
import com.softNice.nikah.utility.validation;


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
		 settingBean bean = dao.getSetting(type);
		 if(request!=null){
			 request.setAttribute("settingObj", bean);
		 }
		 
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
		
		if (request.getParameter("txtEmailType") == null || request.getParameter("txtEmailType").trim().length() == 0){
			return new ErrorMsg(1, "Email type field is required");
		}
		maileBean.setEmail_type(request.getParameter("txtEmailType"));
		
		if (request.getParameter("txtServerName") == null || request.getParameter("txtServerName").trim().length() == 0){
			return new ErrorMsg(1, "Server name field is required");
		}
		maileBean.setServer_name(request.getParameter("txtServerName"));
		
		if (request.getParameter("txtUserName") == null || request.getParameter("txtUserName").trim().length() == 0){
			return new ErrorMsg(1, "User name field is required");
		}
		maileBean.setUserName(request.getParameter("txtUserName"));
		
		if (request.getParameter("txtPassword") == null || request.getParameter("txtPassword").trim().length() == 0){
			return new ErrorMsg(1, "Password field is required");
		}
		maileBean.setPassword(request.getParameter("txtPassword"));
		
		if (request.getParameter("txtPort") == null || request.getParameter("txtPort").trim().length() == 0){
			return new ErrorMsg(1, "Port field is required");
		}else if(request.getParameter("txtPort").length()!=4){
			return new ErrorMsg(1, "port number should be with 4 digit");
		}else {
			try{
				Integer.parseInt(request.getParameter("txtPort"));
			}catch(NumberFormatException ee){
				return new ErrorMsg(1, "port number is not in digit");
			}
		}
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

	public ErrorMsg updateGeneral(generalSettingBean requestbean,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		administratorDAO dao= new administratorImpl();
		ObjectMapper mapperObj = new ObjectMapper();
		settingBean setbean = dao.getSetting("general_setting");
		generalSettingBean genSettingBean=new generalSettingBean();
		if(setbean.getValue()!=null){
			genSettingBean = new Gson().fromJson(setbean.getValue(),generalSettingBean.class);
		}
		genSettingBean.setApp_name(requestbean.getApp_name());
		genSettingBean.setCopyRight(requestbean.getCopyRight());
		if(requestbean.getLogo().length()>0){
			genSettingBean.setLogo(requestbean.getLogo());
		}
		
		
		try {
			
			setbean.setValue(mapperObj.writeValueAsString(genSettingBean));
			
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
		
		int flag = dao.updateSetting(setbean);
		
		if(flag!=0){
			return new ErrorMsg(0, "General setting update failed");
		}else{
			setbean = getSetting("general_setting", request);
		}
		
		return new ErrorMsg(0, "General setting updated sucessfully");
		
	}

	public ErrorMsg validateMaster(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		masterBean bean=new masterBean();
		if(request.getParameter("masterName").equals("0")){
			return new ErrorMsg(1, "Basics details field is required");
		}
		bean.setMasterId(Integer.parseInt(request.getParameter("masterName")));
		
		if (request.getParameter("txtValue") == null || request.getParameter("txtValue").trim().length() == 0){
			return new ErrorMsg(1, "Value field is required");
		}
		bean.setValue(request.getParameter("txtValue"));
		bean.setStatus(true);
		
		administratorDAO dao= new administratorImpl();
		int flag = dao.insertMaster(bean);
		if(flag!=0){
			return new ErrorMsg(1, "Basic details insert failed");
		}
		
		getAllMaster(request);
		return new ErrorMsg(0, "Basic details inserted successfully");
	}  
	
	public void getAllMaster(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		ArrayList<masterBean> list=dao.getAllMasters();
		request.setAttribute("masterMapObj", list);
		
	}

	public ErrorMsg deleteMaster(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		administratorDAO dao=new administratorImpl();
		masterBean bean= dao.getMasterBaseonID(Integer.parseInt(request.getParameter("id")));
		bean.setStatus(false);
		
		int flag = dao.deleteMaster(bean);
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		getAllMaster(request);
		return new ErrorMsg(0, "Basic details deleted successfully");
		
	}

}
