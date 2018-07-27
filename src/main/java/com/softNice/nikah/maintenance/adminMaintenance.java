package com.softNice.nikah.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;
import com.softNice.nikah.utility.EncrypitDecrypit;
import com.softNice.nikah.utility.validation;

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

	public void getAllCountry(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		ArrayList<countryBean> list =dao.getAllCountry();
		request.setAttribute("countryObj", list);
		
	}

	public boolean checkDublicateUserName(String str){
		administratorDAO dao=new administratorImpl();
		boolean flag = dao.checkDublicateUserName(str);
		return flag;
		
	}
	
	public boolean checkDublicateEmail(String str){
		administratorDAO dao=new administratorImpl();
		boolean flag = dao.checkDublicateEmail(str);
		return flag;
		
	}
	
	public boolean checkDublicatePhone(String str){
		administratorDAO dao=new administratorImpl();
		boolean flag = dao.checkDublicatePhone(str);
		return flag;
		
	}
	
	public Object addvalidation(HttpServletRequest request){
		
		UserBean bean=new UserBean();
		getAllCountry(request);
		roleMaintenance.getInstance().getAllRole(request);
		if (request.getParameter("txtUserName") == null	|| request.getParameter("txtUserName").trim().length() == 0){
			return new ErrorMsg(1, "User name field is required");
		}else if(!checkDublicateUserName(request.getParameter("txtUserName"))){
			return new ErrorMsg(1, "User name is already exist");
			
		}
		bean.setUserName(request.getParameter("txtUserName"));
		
		if (request.getParameter("txtFirstName") == null	|| request.getParameter("txtFirstName").trim().length() == 0){
			return new ErrorMsg(1, "First name field is required");
		}
		bean.setFirstName(request.getParameter("txtFirstName"));
		
		if (request.getParameter("txtLastName") == null	|| request.getParameter("txtLastName").trim().length() == 0){
			return new ErrorMsg(1, "Last name field is required");
		}
		bean.setLastName(request.getParameter("txtLastName"));
		
		if (request.getParameter("txtDob") == null	|| request.getParameter("txtDob").trim().length() == 0){
			return new ErrorMsg(1, "DOB field is required");
		}
		bean.setDob(validation.convertStringToDate(request.getParameter("txtDob")));
		
		if (request.getParameter("gender") == null	|| request.getParameter("gender").trim().length() == 0){
			return new ErrorMsg(1, "Gender field is required");
		}
		bean.setGender(request.getParameter("gender"));
		
		if (request.getParameter("country").equals("0") || request.getParameter("country").trim().length() == 0){
			return new ErrorMsg(1, "Please select country");
		}
		bean.setCountry(Integer.parseInt(request.getParameter("country")));
		
		if (request.getParameter("state").equals("0") || request.getParameter("state").trim().length() == 0){
			return new ErrorMsg(1, "Please select state");
		}
		bean.setState(Integer.parseInt(request.getParameter("state")));
		
		if (request.getParameter("city").equals("0") || request.getParameter("city").trim().length() == 0){
			return new ErrorMsg(1, "Please select city");
		}
		bean.setCity(Integer.parseInt(request.getParameter("city")));
		
		if (request.getParameter("txtEmail") == null || request.getParameter("txtEmail").trim().length() == 0){
			return new ErrorMsg(1, "Email field is required");
		}else if(!validation.checkEmail(request.getParameter("txtEmail"))){
			return new ErrorMsg(1, "Email is invalid");
		}else if(!checkDublicateEmail(request.getParameter("txtEmail"))){
			return new ErrorMsg(1, "Email is already exist");
		}
		bean.setEmail(request.getParameter("txtEmail"));
		
		
		if (request.getParameter("txtPhno")  == null || request.getParameter("txtPhno").trim().length() == 0){
			return new ErrorMsg(1, "Phone field is required");
		}else if(!validation.checkPhno(request.getParameter("txtPhno"))){
			return new ErrorMsg(1, "Phone is invalid");
		}else if(!checkDublicatePhone(request.getParameter("txtPhno"))){
			return new ErrorMsg(1, "Phone is already exist");
		}
		bean.setPhno(request.getParameter("txtPhno"));
		
		
		if (request.getParameter("role").equals("0") || request.getParameter("role").trim().length() == 0){
			return new ErrorMsg(1, "Please select role");
		}
		bean.setRoleId(Integer.parseInt(request.getParameter("role")));
		
		if (request.getParameter("txtPsw") == null || request.getParameter("txtPsw").trim().length() == 0){
			return new ErrorMsg(1, "Password field is required");
		}
		if(request.getParameter("txtConfPsw") == null || request.getParameter("txtConfPsw").trim().length() == 0){
			return new ErrorMsg(1, "Password mismatch");
		}
		
		if(!request.getParameter("txtPsw").equals(request.getParameter("txtConfPsw"))){
			return new ErrorMsg(1, "Password mismatch");
		}
		
		try {
			bean.setPassword(EncrypitDecrypit.encrypt(request.getParameter("txtPsw"), "password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bean.setCreatedBy("admin");
		bean.setCreationDate(new Date());
		bean.setStatus(true);
		request.setAttribute("localObj", bean);
		
		administratorDAO dao=new administratorImpl();
		int flag = dao.insertUser(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		ArrayList<UserBean> list=getAllUsers(request);
		
		return new ErrorMsg(0, "User created sucessfully");
	}
	
	public UserBean getUserbyId(HttpServletRequest request){
		
		administratorDAO dao=new administratorImpl();
		UserBean bean = dao.getUserbyId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("modifyObj", bean);
		return bean;
	}

	public ErrorMsg deleteUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		UserBean bean = getUserbyId(request);
		bean.setStatus(false);
		
		int flag = dao.updateUser(bean);
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		ArrayList<UserBean> list = getAllUsers(request);
		
		return new ErrorMsg(0, "User Deleted sucessfully");
		
	}
}
