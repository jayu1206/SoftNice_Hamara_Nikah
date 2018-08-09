package com.softNice.nikah.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.memberBean;
import com.softNice.nikah.beans.memberDetailsBean;
import com.softNice.nikah.beans.memberPlanBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.dao.memberDAO;
import com.softNice.nikah.impl.administratorImpl;
import com.softNice.nikah.impl.memberImpl;
import com.softNice.nikah.utility.EncrypitDecrypit;
import com.softNice.nikah.utility.validation;

public class memberMaintenance {
	
	static Logger log = Logger.getLogger(memberMaintenance.class.getName()); 
	
	 private static memberMaintenance adminObj;  
	 private memberMaintenance() {  }  
	
	 public static memberMaintenance getInstance() {    
       if (adminObj==null)  
     {  
       	adminObj=new  memberMaintenance();  
     }  
       	return adminObj;  
	 }

	public ArrayList<memberPlanBean> getAllMemberPlan(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao = new memberImpl();
		ArrayList<memberPlanBean> list = dao.getAllPlan();
		request.setAttribute("memberPlanObj", list);
		return list;
		
	}

	public ErrorMsg validationMemberPlan(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberPlanBean bean = new memberPlanBean();
		UserBean loginUserbean=null;
		if(request.getSession().getAttribute(contentPage.USERSOBJ)!=null){
			loginUserbean = (UserBean) request.getSession().getAttribute(contentPage.USERSOBJ);
		}
		
		if (request.getParameter("txtPlanName")  == null || request.getParameter("txtPlanName").trim().length() == 0){
			return new ErrorMsg(1, "Name field is required");
		}
		bean.setPlanName(request.getParameter("txtPlanName"));
		
		if (request.getParameter("txtCredits")  == null || request.getParameter("txtPlanName").trim().length() == 0){
			return new ErrorMsg(1, "Credit field is required");
		}else if (!validation.isNumberFormate(request.getParameter("txtCredits"))){
			return new ErrorMsg(1, "Credit should be in number formate");
		}
		bean.setCredits(Integer.parseInt(request.getParameter("txtCredits")));
		
		if (request.getParameter("txtValidity")  == null || request.getParameter("txtValidity").trim().length() == 0){
			return new ErrorMsg(1, "Plan Validity field is required");
		}else if (!validation.isNumberFormate(request.getParameter("txtValidity"))){
			return new ErrorMsg(1, "Validity should be in number formate");
		}
		bean.setPlanValidity(Integer.parseInt(request.getParameter("txtValidity")));
		
		if (request.getParameter("txtCharges")  == null || request.getParameter("txtCharges").trim().length() == 0){
			return new ErrorMsg(1, "Charges field is required");
		}else if (!validation.isNumberFormate(request.getParameter("txtCharges"))){
			return new ErrorMsg(1, "Validity should be in number formate");
		}
		bean.setPlanCharges(Integer.parseInt(request.getParameter("txtCharges")));
		
		if (request.getParameter("txtOrder")  == null || request.getParameter("txtOrder").trim().length() == 0){
			return new ErrorMsg(1, "Order field is required");
		}else if (!validation.isNumberFormate(request.getParameter("txtOrder"))){
			return new ErrorMsg(1, "Order should be in number formate");
		}
		bean.setOrder(Integer.parseInt(request.getParameter("txtOrder")));
		
		if (request.getParameter("PrintView") == null	|| request.getParameter("PrintView").trim().length() == 0){
			return new ErrorMsg(1, "PrintView field is required");
		}
		if(request.getParameter("PrintView").equals("Yes")){
			bean.setPrintedView(true);
		}
		if(request.getParameter("PrintView").equals("No")){
			bean.setPrintedView(false);
		}
		
		
		
		if (request.getParameter("photoUpload") == null	|| request.getParameter("photoUpload").trim().length() == 0){
			return new ErrorMsg(1, "photoUpload field is required");
		}
		if(request.getParameter("photoUpload").equals("Yes")){
			bean.setPhotoUpload(true);
		}
		if(request.getParameter("photoUpload").equals("No")){
			bean.setPhotoUpload(false);
		}
		
		
		if (request.getParameter("horoscopeUpload") == null	|| request.getParameter("horoscopeUpload").trim().length() == 0){
			return new ErrorMsg(1, "horoscopeUpload field is required");
		}
		if(request.getParameter("horoscopeUpload").equals("Yes")){
			bean.setHoroscopeUpload(true);
		}
		if(request.getParameter("horoscopeUpload").equals("No")){
			bean.setHoroscopeUpload(false);
		}
		
		
		if (request.getParameter("horoscopeView") == null	|| request.getParameter("horoscopeView").trim().length() == 0){
			return new ErrorMsg(1, "horoscopeUpload field is required");
		}
		if(request.getParameter("horoscopeView").equals("Yes")){
			bean.setHoroscopeView(true);
		}
		if(request.getParameter("horoscopeView").equals("No")){
			bean.setHoroscopeView(false);
		}
		
		if (request.getParameter("videoUpload") == null	|| request.getParameter("videoUpload").trim().length() == 0){
			return new ErrorMsg(1, "videoUpload field is required");
		}
		if(request.getParameter("videoUpload").equals("Yes")){
			bean.setVideoUpload(true);
		}
		if(request.getParameter("videoUpload").equals("No")){
			bean.setVideoUpload(false);
		}
		
		if (request.getParameter("protectPhoto") == null	|| request.getParameter("protectPhoto").trim().length() == 0){
			return new ErrorMsg(1, "protectPhoto field is required");
		}
		if(request.getParameter("protectPhoto").equals("Yes")){
			bean.setProtectPhoto(true);
		}
		if(request.getParameter("protectPhoto").equals("No")){
			bean.setProtectPhoto(false);
		}
		
		if (request.getParameter("bookmark") == null	|| request.getParameter("bookmark").trim().length() == 0){
			return new ErrorMsg(1, "bookmark field is required");
		}
		if(request.getParameter("bookmark").equals("Yes")){
			bean.setBookmark(true);
		}
		if(request.getParameter("bookmark").equals("No")){
			bean.setBookmark(false);
		}
		
		
		
		if (request.getParameter("messaging") == null	|| request.getParameter("messaging").trim().length() == 0){
			return new ErrorMsg(1, "messaging field is required");
		}
		if(request.getParameter("messaging").equals("Yes")){
			bean.setMessaging(true);
		}
		if(request.getParameter("messaging").equals("No")){
			bean.setMessaging(false);
		}
		
		if (request.getParameter("serviceTex") == null	|| request.getParameter("serviceTex").trim().length() == 0){
			return new ErrorMsg(1, "messaging field is required");
		}
		if(request.getParameter("serviceTex").equals("Yes")){
			bean.setMessaging(true);
		}
		if(request.getParameter("serviceTex").equals("No")){
			bean.setMessaging(false);
		}
		
		bean.setStatus(true);
		bean.setCreatedBy(loginUserbean.getUserName());
		bean.setCreationDate(new Date());
		
		
		memberDAO dao = new memberImpl();
		int flag = dao.insertMemberPlan(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		ArrayList<memberPlanBean> list = getAllMemberPlan(request);
		
		
		return new ErrorMsg(0, "Plan created sucessfully");
	}

	public ErrorMsg deleteMemberPlan(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao= new memberImpl();
		memberPlanBean bean= dao.getMemberPlanById(Integer.parseInt(request.getParameter("id")));
		bean.setStatus(false);
		
		int flag=dao.deleteMemberPlan(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		ArrayList<memberPlanBean> list=getAllMemberPlan(request);
		return new ErrorMsg(0, "Plan created sucessfully");
		
	}

	public memberBean authentication(HttpServletRequest request) {
		// TODO Auto-generated method stub
		/*administratorDAO dao=new administratorImpl();
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
		return bean;*/
		String userName = request.getParameter("txtUserName");
		String password="";
		try {
			password = EncrypitDecrypit.encrypt(request.getParameter("txtPsw"), "password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memberDAO dao=new memberImpl();
		memberBean bean=dao.loginMemberAuth(userName,password);
		
		return bean;
	}

	public ErrorMsg newRegistration(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberBean bean= new memberBean();
		
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
		
		if (request.getParameter("txtPsw") == null	|| request.getParameter("txtPsw").trim().length() == 0){
			return new ErrorMsg(1, "First name field is required");
		}
		try {
			bean.setPassword(EncrypitDecrypit.encrypt(request.getParameter("txtPsw"), "password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bean.setStatus(true);
		
		 String str[]=UUID.randomUUID().toString().split("-");
         bean.setMemberId(str[0].toUpperCase());
		 bean.setCreationDate(new Date());
		 
		memberPlanBean planBean = memberMaintenance.getInstance().getFreeMemberPlan();
		bean.setPlanID(planBean.getPlanId());
		
		memberDAO dao=new memberImpl();
		int flag = dao.newRegisterMember(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		
		
		
		return new ErrorMsg(0, "User created sucessfully");
	}

	private memberPlanBean getFreeMemberPlan() {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		memberPlanBean bean=dao.getFreeMembershipPlan();
		return bean;
	}

	private boolean checkDublicateEmail(String str, int id) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		boolean flag = dao.checkDublicateEmail(str,id);
		return flag;
	}

	public ErrorMsg addMemberOtherDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		
		memberBean bean=dao.getMemberBaseOnId( Integer.parseInt(request.getParameter("txtId")));
		memberDetailsBean details = new memberDetailsBean();
		details.setFamilyStatus(request.getParameter("rblFamilyStatus"));
		details.setCulture(Integer.parseInt(request.getParameter("culture")));
		details.setHeight(Integer.parseInt(request.getParameter("height")));
		details.setWeight(Integer.parseInt(request.getParameter("weight")));
		details.setBuilt(Integer.parseInt(request.getParameter("built")));
		details.setComplexion(Integer.parseInt(request.getParameter("complexion")));
		details.setDiet(Integer.parseInt(request.getParameter("diet")));
		details.setDrink(Integer.parseInt(request.getParameter("drink")));
		details.setSmoke(Integer.parseInt(request.getParameter("smoke")));
		details.setAbout(request.getParameter("about"));
		details.setEducation(Integer.parseInt(request.getParameter("education")));
		details.setProfession(Integer.parseInt(request.getParameter("profession")));
		details.setIncome(Integer.parseInt(request.getParameter("income")));
		details.setVisaStatus(request.getParameter("visa"));
		details.setMemberId(bean.getId());
		
		Set<memberDetailsBean> setlist=new HashSet<memberDetailsBean>();
		setlist.add(details);
		bean.setDetails(setlist);
		request.getSession().setAttribute(contentPage.USERSOBJ,bean);
		int flag = dao.insertMemberDetails(details);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		return new ErrorMsg(0, "Done");
		
		
	}

	public void getAllMembers(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		ArrayList<memberBean> list=dao.getAllMembers();
		request.setAttribute("members", list);
		
	}


}