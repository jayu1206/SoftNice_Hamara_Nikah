package com.softNice.nikah.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softNice.nikah.beans.memberBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.memberMaintenance;
import com.softNice.nikah.maintenance.roleMaintenance;

/**
 * Servlet implementation class memberServlet
 */
public class memberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		if(request.getParameter("key")!=null){
			
			if(request.getParameter("key").equals("logout")){
				request.getSession().invalidate();
				rd=request.getRequestDispatcher("/MemberLogin.jsp");  
				rd.forward(request, response); 
				
			}
			if(request.getParameter("key").equals("register")){
				adminMaintenance.getInstance().getAllCountry(request);
				request.getSession().setAttribute(contentPage.SETTING, getServletContext().getAttribute(contentPage.SETTING));
				rd=request.getRequestDispatcher("/registration.jsp");  
				rd.forward(request, response);
				
			}
			if(request.getParameter("key").equals("uploadPhotos")){
				
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberPhotos.jsp");
				rd=request.getRequestDispatcher("/memberIndex.jsp");  
				rd.forward(request, response); 
			}
			
				
		}else{
			rd=request.getRequestDispatcher("/MemberLogin.jsp");  
			rd.forward(request, response); 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		
		if(request.getParameter("key")!=null){
			
			if(request.getParameter("key").equals("register")){
				
				request.getSession().setAttribute(contentPage.SETTING, getServletContext().getAttribute(contentPage.SETTING));
				rd=request.getRequestDispatcher("/registration.jsp");  
				rd.forward(request, response);
				
			}
			if(request.getParameter("key").equals("login")){
				memberBean bean = memberMaintenance.getInstance().authentication(request);
				if(bean!=null){
					
					request.getSession().setAttribute(contentPage.USERSOBJ,bean);
					HashMap<String, permissionBean> map=new HashMap<String, permissionBean>();
					
					
					request.getSession().setAttribute(contentPage.MAPOBJ, map);
					request.getSession().setAttribute(contentPage.PERMISSIONNAME,getServletContext().getAttribute(contentPage.PERMISSIONNAME));
					request.getSession().setAttribute(contentPage.MASTERMAPOBJ, getServletContext().getAttribute(contentPage.MASTERMAPOBJ));
					request.getSession().setAttribute(contentPage.SETTING, getServletContext().getAttribute(contentPage.SETTING));
					
					if(bean.getDetails().size()==0){
						request.setAttribute(contentPage.CONTENT_PAGE, "/memberOtherDetailsHome.jsp");
						
						//System.out.println("empty details page");
					}else{
						request.setAttribute(contentPage.CONTENT_PAGE, "/memberOtherDetailsHome.jsp");
						//request.setAttribute(contentPage.CONTENT_PAGE, "/memberHome.jsp");
					}
					
					
					
					memberMaintenance.getInstance().getAllMemberPlan(request);
					
					HashMap<Integer, String> map2 = new HashMap<Integer, String>();
					if(request.getSession().getAttribute(contentPage.MASTERMAPOBJ)!=null){
						map2 = (HashMap<Integer, String>)  request.getSession().getAttribute(contentPage.MASTERMAPOBJ);
						for(Map.Entry m:map2.entrySet()){
							adminMaintenance.getInstance().getMasterBaseOnId((int)m.getKey(),m.getValue().toString(),request);
							
						}
					}
					adminMaintenance.getInstance().getAllCountry(request);
					
					
					rd=request.getRequestDispatcher("/memberIndex.jsp");  
					rd.forward(request, response); 
					
				}else{
					
					ErrorMsg error=new ErrorMsg(1,"Invalid Username or Password");
					request.setAttribute("error", error);
					rd=request.getRequestDispatcher("/MemberLogin.jsp");  
					rd.forward(request, response); 
				}
				
			}
			
			if(request.getParameter("key").equals("newRegister")){
				adminMaintenance.getInstance().getAllCountry(request);
				ErrorMsg obj=(ErrorMsg) memberMaintenance.getInstance().newRegistration(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					rd=request.getRequestDispatcher("/registration.jsp");  
					rd.forward(request, response); 
				}else{
					rd=request.getRequestDispatcher("/MemberLogin.jsp");  
					rd.forward(request, response); 
				}
				
				
			}
			
			if(request.getParameter("key").equals("addMember")){
				
				ErrorMsg obj=(ErrorMsg) memberMaintenance.getInstance().addMemberOtherDetails(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/memberOtherDetailsHome.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/memberHome.jsp");
				}
				
				rd=request.getRequestDispatcher("/memberIndex.jsp");  
				rd.forward(request, response); 
				
			}
			
		/*	if(!request.getParameter("key").equals("login") && !request.getParameter("key").equals("register")){
				
				
			}*/
			
			
			
		}else{
			rd=request.getRequestDispatcher("/MemberLogin.jsp");  
			rd.forward(request, response); 
		}
		
	}

}
