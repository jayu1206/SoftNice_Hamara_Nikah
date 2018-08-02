package com.softNice.nikah.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.citiesBean;
import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.masterBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.beans.statesBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
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

	public void getAllState(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		ArrayList<statesBean> list =dao.getAllState();
		request.setAttribute("stateObj", list);
		
	}
	
	
	public boolean checkDublicateUserName(String str,int action){
		administratorDAO dao=new administratorImpl();
		boolean flag = dao.checkDublicateUserName(str,action);
		return flag;
		
	}
	
	public boolean checkDublicateEmail(String str, int id){
		administratorDAO dao=new administratorImpl();
		boolean flag = dao.checkDublicateEmail(str,id);
		return flag;
		
	}
	
	public boolean checkDublicatePhone(String str,int id){
		administratorDAO dao=new administratorImpl();
		boolean flag = dao.checkDublicatePhone(str,id);
		return flag;
		
	}
	
	public Object addvalidation(HttpServletRequest request){
		
		UserBean loginUserbean=null;
		if(request.getSession().getAttribute(contentPage.USERSOBJ)!=null){
			loginUserbean = (UserBean) request.getSession().getAttribute(contentPage.USERSOBJ);
		}
		
		UserBean bean=new UserBean();
		getAllCountry(request);
		roleMaintenance.getInstance().getAllRole(request);
		if (request.getParameter("txtUserName") == null	|| request.getParameter("txtUserName").trim().length() == 0){
			return new ErrorMsg(1, "User name field is required");
		}else if(!checkDublicateUserName(request.getParameter("txtUserName"),0)){
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
		}else if(!checkDublicateEmail(request.getParameter("txtEmail"),0)){
			return new ErrorMsg(1, "Email is already exist");
		}
		bean.setEmail(request.getParameter("txtEmail"));
		
		
		if (request.getParameter("txtPhno")  == null || request.getParameter("txtPhno").trim().length() == 0){
			return new ErrorMsg(1, "Phone field is required");
		}else if(!validation.checkPhno(request.getParameter("txtPhno"))){
			return new ErrorMsg(1, "Phone is invalid");
		}else if(!checkDublicatePhone(request.getParameter("txtPhno"),0)){
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
		bean.setCreatedBy(loginUserbean.getUserName());
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
		try {
			bean.setPassword(EncrypitDecrypit.encrypt(bean.getPassword(), "password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int flag = dao.updateUser(bean);
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		ArrayList<UserBean> list = getAllUsers(request);
		
		return new ErrorMsg(0, "User Deleted sucessfully");
		
	}

	public ErrorMsg updateValidation(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		UserBean loginUserbean=null;
		if(request.getSession().getAttribute(contentPage.USERSOBJ)!=null){
			loginUserbean = (UserBean) request.getSession().getAttribute(contentPage.USERSOBJ);
		}
		
		UserBean bean=new UserBean();
		getAllCountry(request);
		roleMaintenance.getInstance().getAllRole(request);
		if (request.getParameter("txtUserName") == null	|| request.getParameter("txtUserName").trim().length() == 0){
			return new ErrorMsg(1, "User name field is required");
		}else if(!checkDublicateUserName(request.getParameter("txtUserName"),Integer.parseInt(request.getParameter("txtId")))){
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
		}else if(!checkDublicateEmail(request.getParameter("txtEmail"),Integer.parseInt(request.getParameter("txtId")))){
			return new ErrorMsg(1, "Email is already exist");
		}
		bean.setEmail(request.getParameter("txtEmail"));
		
		
		if (request.getParameter("txtPhno")  == null || request.getParameter("txtPhno").trim().length() == 0){
			return new ErrorMsg(1, "Phone field is required");
		}else if(!validation.checkPhno(request.getParameter("txtPhno"))){
			return new ErrorMsg(1, "Phone is invalid");
		}else if(!checkDublicatePhone(request.getParameter("txtPhno"),Integer.parseInt(request.getParameter("txtId")))){
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
		bean.setCreatedBy(loginUserbean.getUserName());
		bean.setCreationDate(new Date());
		bean.setStatus(true);
		bean.setId(Integer.parseInt(request.getParameter("txtId")));
		request.setAttribute("localObj", bean);
		
		administratorDAO dao=new administratorImpl();
		int flag = dao.updateUser(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		ArrayList<UserBean> list=getAllUsers(request);
		
		return new ErrorMsg(0, "User updated sucessfully");
		
		
	}

	
	public UserBean authentication(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		//request.getParameter("txtUserName").equals("admin") && request.getParameter("txtPsw").equals("admin")
		String userName = request.getParameter("txtUserName");
		String password="";
		try {
			password = EncrypitDecrypit.encrypt(request.getParameter("txtPsw"), "password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserBean bean=dao.loginUserAuth(userName,password);
		return bean;
	}

	public ErrorMsg validationCountry(HttpServletRequest request) {
		// TODO Auto-generated method stub
		adminMaintenance.getInstance().getAllCountry(request);
		countryBean bean=new countryBean();
		
		if (request.getParameter("txtCountryName")  == null || request.getParameter("txtCountryName").trim().length() == 0){
			return new ErrorMsg(1, "Country name field is required");
		}else if(!checkDubplicateCountry(request.getParameter("txtCountryName"),"name")){
			return new ErrorMsg(1, "Country is already exist");
		}
		bean.setName(request.getParameter("txtCountryName"));
		
		if (request.getParameter("txtShortName")  == null || request.getParameter("txtShortName").trim().length() == 0){
			return new ErrorMsg(1, "Short name field is required");
		}else if(!checkDubplicateCountry(request.getParameter("txtShortName"),"sortname")){
			return new ErrorMsg(1, "Short is already exist");
		}
		bean.setSortname(request.getParameter("txtShortName"));
		
		if (request.getParameter("txtPhCode")  == null || request.getParameter("txtPhCode").trim().length() == 0){
			return new ErrorMsg(1, "Phone code field is required");
		}else if(!checkDubplicateCountry(request.getParameter("txtPhCode"),"phonecode")){
			return new ErrorMsg(1, "Phonecode is already exist");
		}
		bean.setPhonecode(Integer.parseInt(request.getParameter("txtPhCode")));
		bean.setStatus(true);
		
		
		
		administratorDAO dao= new administratorImpl();
		int flag=dao.insertCountry(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		getAllCountry(request);
		return new ErrorMsg(0, "Country created sucessfully");
		
		
	}

	private boolean checkDubplicateCountry(String str,String field) {
		// TODO Auto-generated method stub
		administratorDAO dao= new administratorImpl();
		boolean falg = dao.checkDublicateCountry(field,str);
		return falg;
	}

	public ErrorMsg validationState(HttpServletRequest request) {
		// TODO Auto-generated method stub
		adminMaintenance.getInstance().getAllCountry(request);
		statesBean bean = new statesBean();
		if (request.getParameter("country").equals("0")){
			return new ErrorMsg(1, "Country field is required");
		}
		bean.setCountryId(Integer.parseInt(request.getParameter("country")));
		
		if (request.getParameter("txtStateName")  == null || request.getParameter("txtStateName").trim().length() == 0){
			return new ErrorMsg(1, "State field is required");
		}
		bean.setName(request.getParameter("txtStateName"));
		if(!checkDublicateState(Integer.parseInt(request.getParameter("country")),request.getParameter("txtStateName"))){
			return new ErrorMsg(1, "State is already exist");
		}
		bean.setStatus(true);
		
		administratorDAO dao= new administratorImpl();
		int flag=dao.insertState(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		getAllState(request);
		 return new ErrorMsg(0, "State created sucessfully");
	}

	private boolean checkDublicateState(int countryId, String state) {
		// TODO Auto-generated method stub
		administratorDAO dao= new administratorImpl();
		boolean flag = dao.checkDublicateState(countryId,state);
		return flag;
	}

	public ErrorMsg deleteState(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		statesBean bean = dao.getStateById(Integer.parseInt(request.getParameter("id")));
		bean.setStatus(false);
		
		int flag = dao.deleteState(bean);
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		getAllState(request);
		return new ErrorMsg(0, "State deleted successfully");
		
	}

	public ErrorMsg deleteCountry(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		countryBean bean = dao.getCountryById(Integer.parseInt(request.getParameter("id")));
		bean.setStatus(false);
		
		int flag = dao.deleteCountry(bean);
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		getAllState(request);
		return new ErrorMsg(0, "Country deleted successfully");
	}

	public void getAllCity(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		ArrayList<citiesBean> list =dao.getAllCity();
		request.setAttribute("cityObj", list);
	}

	private boolean checkDublicateCity(int stateId, String city) {
		// TODO Auto-generated method stub
		administratorDAO dao= new administratorImpl();
		boolean flag = dao.checkDublicateCity(stateId,city);
		return flag;
	}
	
	public ErrorMsg validationCity(HttpServletRequest request) {
		// TODO Auto-generated method stub
		adminMaintenance.getInstance().getAllCountry(request);
		citiesBean bean=new citiesBean();
		
		if (request.getParameter("country").equals("0")){
			return new ErrorMsg(1, "Country field is required");
		}
		
		if (request.getParameter("state").equals("0")){
			return new ErrorMsg(1, "State field is required");
		}
		bean.setStateId(Integer.parseInt(request.getParameter("state")));
		
		
		if (request.getParameter("txtCity")  == null || request.getParameter("txtCity").trim().length() == 0){
			return new ErrorMsg(1, "City name field is required");
		}
		if(!checkDublicateCity(bean.getStateId(),request.getParameter("txtCity"))){
			return new ErrorMsg(1, "City name already Exist");
		}
		bean.setName(request.getParameter("txtCity"));
		
		bean.setStatus(true);
		
		administratorDAO dao= new administratorImpl();
		int flag=dao.insertCity(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		request.setAttribute("cityObj", null);
		getAllCity(request);
		 return new ErrorMsg(0, "City created sucessfully");
		
	}

	public void getMasterBaseOnId(int key, String value, HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao= new administratorImpl();
		ArrayList<masterBean>   list=dao.getMasterBaseOnMasterID(key);
		request.setAttribute(value, list);
		/*map.put(1,"Religion");
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
		map.put(12,"Smoke"); */
		
		
		
		
	}

	
}
