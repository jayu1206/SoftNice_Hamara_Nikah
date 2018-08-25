package com.softNice.nikah.maintenance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.generalSettingBean;
import com.softNice.nikah.beans.memberBean;
import com.softNice.nikah.beans.memberDetailsBean;
import com.softNice.nikah.beans.memberPlanBean;
import com.softNice.nikah.beans.memberStoryBean;
import com.softNice.nikah.beans.orderBean;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.dao.memberDAO;
import com.softNice.nikah.database.HibernateFactory;
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
		bean.setAge( validation.countAge(bean.getDob())  );
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
		
		if (request.getParameter("txtPhno")  == null || request.getParameter("txtPhno").trim().length() == 0){
			return new ErrorMsg(1, "Phone field is required");
		}else if(!validation.checkPhno(request.getParameter("txtPhno"))){
			return new ErrorMsg(1, "Phone is invalid");
		}else if(!checkDublicatePhone(request.getParameter("txtPhno"),bean.getId())){
			return new ErrorMsg(1, "Phone is already exist");
		}
		bean.setPhno(request.getParameter("txtPhno"));
		
		memberDetailsBean details = new memberDetailsBean();
		
		if (request.getParameter("rblFamilyStatus") == null	|| request.getParameter("rblFamilyStatus").trim().length() == 0){
			return new ErrorMsg(1, "Family status is required");
		}
		details.setFamilyStatus(request.getParameter("rblFamilyStatus"));
		
		if (request.getParameter("culture").equals("0") || request.getParameter("culture").trim().length() == 0){
			return new ErrorMsg(1, "Please select culture");
		}
		details.setCulture(Integer.parseInt(request.getParameter("culture")));
		
		if (request.getParameter("height").equals("0") || request.getParameter("height").trim().length() == 0){
			return new ErrorMsg(1, "Please select height");
		}
		details.setHeight(Integer.parseInt(request.getParameter("height")));
		
		if (request.getParameter("weight").equals("0") || request.getParameter("weight").trim().length() == 0){
			return new ErrorMsg(1, "Please select weight");
		}
		details.setWeight(Integer.parseInt(request.getParameter("weight")));
		
		if (request.getParameter("built").equals("0") || request.getParameter("built").trim().length() == 0){
			return new ErrorMsg(1, "Please select built");
		}
		details.setBuilt(Integer.parseInt(request.getParameter("built")));
		
		if (request.getParameter("complexion").equals("0") || request.getParameter("complexion").trim().length() == 0){
			return new ErrorMsg(1, "Please select complexion");
		}
		details.setComplexion(Integer.parseInt(request.getParameter("complexion")));
		
		
		if (request.getParameter("diet").equals("0") || request.getParameter("diet").trim().length() == 0){
			return new ErrorMsg(1, "Please select diet");
		}
		details.setDiet(Integer.parseInt(request.getParameter("diet")));
		
		if (request.getParameter("drink").equals("0") || request.getParameter("drink").trim().length() == 0){
			return new ErrorMsg(1, "Please select drink");
		}
		details.setDrink(Integer.parseInt(request.getParameter("drink")));
		
		if (request.getParameter("smoke").equals("0") || request.getParameter("smoke").trim().length() == 0){
			return new ErrorMsg(1, "Please select smoke");
		}
		details.setSmoke(Integer.parseInt(request.getParameter("smoke")));
		
		
		details.setAbout(request.getParameter("about"));
		
		if (request.getParameter("education").equals("0") || request.getParameter("education").trim().length() == 0){
			return new ErrorMsg(1, "Please select education");
		}
		details.setEducation(Integer.parseInt(request.getParameter("education")));
		
		if (request.getParameter("profession").equals("0") || request.getParameter("profession").trim().length() == 0){
			return new ErrorMsg(1, "Please select profession");
		}
		details.setProfession(Integer.parseInt(request.getParameter("profession")));
		
		if (request.getParameter("income").equals("0") || request.getParameter("income").trim().length() == 0){
			return new ErrorMsg(1, "Please select income");
		}
		details.setIncome(Integer.parseInt(request.getParameter("income")));
		
		if (request.getParameter("visa") == null	|| request.getParameter("visa").trim().length() == 0){
			return new ErrorMsg(1, "visa status is required");
		}
		details.setVisaStatus(request.getParameter("visa"));
		
		
		details.setMemberId(bean.getId());
		
		Set<memberDetailsBean> setlist=new HashSet<memberDetailsBean>();
		setlist.add(details);
		bean.setDetails(setlist);
		request.getSession().setAttribute(contentPage.USERSOBJ,bean);
		int flag = dao.insertMemberDetails(details);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}else{
			flag = dao.updateMember(bean);
		}
		
		return new ErrorMsg(0, "Done");
		
		
	}

	public void getAllMembers(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		ArrayList<memberBean> list=dao.getAllMembers();
		request.setAttribute("members", list);
		
	}
	
	public void getAllActiveMembers(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		ArrayList<memberBean> list=dao.getAllActiveMembers();
		request.setAttribute("members", list);
		
	}
	
	public boolean checkDublicatePhone(String str,int id){
		memberDAO dao=new memberImpl();
		boolean flag = dao.checkDublicatePhone(str,id);
		return flag;
		
	}


	public memberPlanBean getmemberPlanById(int planId) {
		// TODO Auto-generated method stub
		memberDAO dao = new memberImpl();
		memberPlanBean bean = dao.getAllPlanByID(planId);
		return bean;
	}

	public ErrorMsg validationForOrder(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		UserBean loginUserbean=null;
		if(request.getSession().getAttribute(contentPage.USERSOBJ)!=null){
			loginUserbean = (UserBean) request.getSession().getAttribute(contentPage.USERSOBJ);
		}
		
		
		orderBean bean=new orderBean();
		if (request.getParameter("memberId").equals("0") || request.getParameter("memberId").trim().length() == 0){
			return new ErrorMsg(1, "Please select Member");
		}
		bean.setMemberId(request.getParameter("memberId"));
		
		if (request.getParameter("planId").equals("0") || request.getParameter("planId").trim().length() == 0){
			return new ErrorMsg(1, "Please select Plan");
		}
		bean.setMemberPlanId( Integer.parseInt(request.getParameter("planId")));
		
		if (request.getParameter("txtStartDate") == null	|| request.getParameter("txtStartDate").trim().length() == 0){
			return new ErrorMsg(1, "Please select start date");
		}
		bean.setStartDate(validation.convertStringToDate(request.getParameter("txtStartDate")));
		
		memberPlanBean memberPlanBean = memberMaintenance.getInstance().getmemberPlanById(bean.getMemberPlanId());
		
		Date date = validation.convertStringToDate(request.getParameter("txtStartDate"));
		date.setDate(date.getDate()+memberPlanBean.getPlanValidity());
		bean.setEndDate( validation.convertStringToDate(validation.convertDateToString(date))); 
		bean.setCreatedBy(loginUserbean.getUserName());
		bean.setCreationDate(new Date());
		
		memberDAO dao=new memberImpl();
		memberBean memberbean=dao.getMemberBaseOnMemberId(bean.getMemberId());
		memberbean.setPlanID(bean.getMemberPlanId());
		
		int flag = dao.updateMember(memberbean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}else{
			flag = dao.insertOrder(bean);
			
			if(flag!=0){
				return new ErrorMsg(2, "Internal Error");
					
			}
		}
		
		return new ErrorMsg(0, "Ordered successfully");
	}
	public void getMemberById(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		String mid = request.getParameter("memberId");
		int id = Integer.parseInt(mid);
		memberBean memberBean=dao.getMemberBaseOnId(id);
		request.getSession().setAttribute(contentPage.MEMBERS,memberBean);
		

	}

	public ErrorMsg addMemberStory(HttpServletRequest request) {
	
		
		// TODO Auto-generated method stub
		memberStoryBean bean= new memberStoryBean();
	
			if (request.getParameter("txtBrideName") == null	|| request.getParameter("txtBrideName").trim().length() == 0){
				return new ErrorMsg(1, "Bride Name field is required");
			}
			bean.setBrideName(request.getParameter("txtBrideName"));
			
			if (request.getParameter("txtGroomName") == null	|| request.getParameter("txtGroomName").trim().length() == 0){
				return new ErrorMsg(1, "Groom Name field is required");
			}
			bean.setGroomName(request.getParameter("txtGroomName"));
			
			if (request.getParameter("txtMemberId") == null	|| request.getParameter("txtMemberId").trim().length() == 0){
				return new ErrorMsg(1, "Member Id field is required");
			}
			bean.setMemberId(request.getParameter("txtMemberId"));
			
			if (request.getParameter("txtPartnerMemberId") == null	|| request.getParameter("txtPartnerMemberId").trim().length() == 0){
				return new ErrorMsg(1, "Partner's Member Id field is required");
			}
			bean.setPartnerMemberId(request.getParameter("txtPartnerMemberId"));
					
			if (request.getParameter("txtEngDate") == null || request.getParameter("txtEngDate").trim().length() == 0){
				return new ErrorMsg(1, "Please select Engagement Date");
			}
			bean.setEngDate(validation.convertStringToDate(request.getParameter("txtEngDate")));
			
			if (request.getParameter("txtMarriageDate") == null || request.getParameter("txtMarriageDate").trim().length() == 0){
				return new ErrorMsg(1, "Please select Marriage Date");
			}
			bean.setMarriageDate(validation.convertStringToDate(request.getParameter("txtMarriageDate")));
			
			if (request.getParameter("txtEmail") == null || request.getParameter("txtEmail").trim().length() == 0){
				return new ErrorMsg(1, "Email field is required");
			}else if(!validation.checkEmail(request.getParameter("txtEmail"))){
				return new ErrorMsg(1, "Email is invalid");
			}else if(!checkDublicateEmail(request.getParameter("txtEmail"),0)){
				return new ErrorMsg(1, "Email is already exist");
			}
			bean.setEmail(request.getParameter("txtEmail"));		
			
			
			
			if (request.getParameter("txtAddress") == null || request.getParameter("txtAddress").trim().length() == 0){
				return new ErrorMsg(1, "Please Enter Address");
			}
			bean.setAddress(request.getParameter("txtAddress"));
			
			if (request.getParameter("country") == null || request.getParameter("country").trim().length() == 0){
				return new ErrorMsg(1, "Please select Country");
			}
			bean.setCountry(request.getParameter("country"));
			
			if (request.getParameter("txtCountryCode").equals("0") || request.getParameter("txtCountryCode").trim().length() == 0){
				return new ErrorMsg(1, "Please select Country Code");
			}
			bean.setAddress(request.getParameter("txtCountryCode"));
			
			if (request.getParameter("txtPhone") == null || request.getParameter("txtPhone").trim().length() == 0){
				return new ErrorMsg(1, "Please Enter Phone");
			}
			bean.setAddress(request.getParameter("txtPhone"));
			
			if (request.getParameter("txtSussessStory") == null || request.getParameter("txtSussessStory").trim().length() == 0){
				return new ErrorMsg(1, "Please Enter Success Story");
			}
			bean.setAddress(request.getParameter("txtSussessStory"));		
			
			
	
		memberDAO dao=new memberImpl();
		int flag = dao.addMemberStory(bean);
		
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		
		return new ErrorMsg(0, "Story created sucessfully");
	
	}

	private String getFileName(Part filePart) {
		final String partHeader = filePart.getHeader("content-disposition");
	    for (String content : filePart.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

	public ErrorMsg insertMemberStory(memberStoryBean bean, HttpServletRequest request) {
		
		// TODO Auto-generated method stub
		Session session=null;
		try {
			
			if (bean.getBrideName() == null	|| bean.getBrideName().length() == 0){
				return new ErrorMsg(1, "Bride Name field is required");
			}
			
			if (bean.getGroomName() == null	|| bean.getGroomName().length() == 0){
				return new ErrorMsg(1, "Groom Name field is required");
			}
			
			if (bean.getMemberId() == null	|| bean.getMemberId().length() == 0){
				return new ErrorMsg(1, "Member Id field is required");
			}
			
			if (bean.getPartnerMemberId() == null	|| bean.getPartnerMemberId().length() == 0){
				return new ErrorMsg(1, "Partner's Member Id field is required");
			}
				
			if (bean.getEngDate() == null || bean.getEngDate().toString().length() == 0){
				return new ErrorMsg(1, "Please select Engagement Date");
			}
			
			if (bean.getMarriageDate() == null || bean.getEngDate().toString().length() == 0){
				return new ErrorMsg(1, "Please select Marriage Date");
			}
			
			if (bean.getEmail() == null || bean.getEmail().length() == 0){
				return new ErrorMsg(1, "Email field is required");
			}else if(!validation.checkEmail(bean.getEmail())){
				return new ErrorMsg(1, "Email is invalid");
			}else if(!checkDublicateEmail(bean.getEmail(),0)){
				return new ErrorMsg(1, "Email is already exist");
			}
			
			if (bean.getAddress() == null || bean.getAddress().length() == 0){
				return new ErrorMsg(1, "Please Enter Address");
			}
			
			if (bean.getCountry() == null || bean.getCountry().length() == 0){
				return new ErrorMsg(1, "Please select Country");
			}
			
			/*if (bean.getCountryCode().equals("0") || bean.getCountryCode().length() == 0){
				return new ErrorMsg(1, "Please select Country Code");
			}*/
			
			if (bean.getPhone() == null || bean.getPhone().length() == 0){
				return new ErrorMsg(1, "Please Enter Phone");
			}
			
			if (bean.getSuccessStory() == null || bean.getSuccessStory().length() == 0){
				return new ErrorMsg(1, "Please Enter Success Story");
			}
			
			session=HibernateFactory.openSession();
			session.save(bean);
			session.flush();
			return new ErrorMsg(0, "Data added sucessfully");

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			return new ErrorMsg(1, "Data Not added..");
			  
		} finally {
			try {
				HibernateFactory.close(session);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	}

	public void getAllStories(HttpServletRequest request) {
		// TODO Auto-generated method stub
		memberDAO dao=new memberImpl();
		ArrayList<memberStoryBean> list =dao.getAllStories();
		request.setAttribute("storyList", list);
		
	}


}
