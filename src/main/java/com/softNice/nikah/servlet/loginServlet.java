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

package com.softNice.nikah.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.memberPlanBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.memberMaintenance;
import com.softNice.nikah.maintenance.roleMaintenance;



/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
				rd=request.getRequestDispatcher("/login.jsp");  
				rd.forward(request, response); 
				
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		UserBean bean=adminMaintenance.getInstance().authentication(request);
		if(bean!=null){
			request.getSession().setAttribute(contentPage.USERSOBJ,bean);
			HashMap<String, permissionBean> map=new HashMap<String, permissionBean>();
			roleBean rolebean = roleMaintenance.getInstance().getRoleBaseOnId(bean.getRoleId());
			if(rolebean != null){
				
				for(permissionBean permissionObj : rolebean.getPermissions()){
					 map.put(permissionObj.getPermissionName(), permissionObj);
				}
				
			}
			
			
			request.getSession().setAttribute(contentPage.MAPOBJ, map);
			request.getSession().setAttribute(contentPage.PERMISSIONNAME,getServletContext().getAttribute(contentPage.PERMISSIONNAME));
			request.getSession().setAttribute(contentPage.MASTERMAPOBJ, getServletContext().getAttribute(contentPage.MASTERMAPOBJ));
			request.getSession().setAttribute(contentPage.SETTING, getServletContext().getAttribute(contentPage.SETTING));
			request.setAttribute(contentPage.CONTENT_PAGE, "/home.jsp");
			
			memberMaintenance.getInstance().getAllMemberPlan(request);
			
			
			rd=request.getRequestDispatcher("/index.jsp");  
			rd.forward(request, response); 
			
		}else{
			
			ErrorMsg error=new ErrorMsg(1,"Invalid Username or Password");
			request.setAttribute("error", error);
			rd=request.getRequestDispatcher("/login.jsp");  
			rd.forward(request, response); 
		}
		
		
	}

}
