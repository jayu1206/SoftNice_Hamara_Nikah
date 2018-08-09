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
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.memberMaintenance;
import com.softNice.nikah.maintenance.roleMaintenance;
import com.softNice.nikah.maintenance.settingMaintenance;

/**
 * Servlet implementation class ContentServlet
 */
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key=request.getParameter("key");
		RequestDispatcher rd = null;
		if(key!=null){
			if(key.equals("role")){
				roleMaintenance.getInstance().getAllRole(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/roleList.jsp");
				
			} 
			
			if(key.equals("updateRole")){
				
				roleMaintenance.getInstance().getRoleBaseOnId(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addRole.jsp");
				
			}
			
			if(key.equals("deleteRole")){
				roleMaintenance.getInstance().deleteRole(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/roleList.jsp");
				
			}
			
			if(key.equals("permission")){
				String id = request.getParameter("id");
				//roleMaintenance.getInstance().getRoleBaseOnId(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/permission.jsp?id="+id+"");
				
			}
			
			if(key.equals("user")){
				adminMaintenance.getInstance().getAllUsers(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/userList.jsp");
			}
			
			if(key.equals("dashboard")){
				//request.getSession().setAttribute(contentPage.PERMISSIONNAME,getServletContext().getAttribute(contentPage.PERMISSIONNAME));
				memberMaintenance.getInstance().getAllMemberPlan(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/home.jsp");
				
			}
			
			if(key.equals("deleteUser")){
				adminMaintenance.getInstance().deleteUser(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/userList.jsp");
				
			}
			
			if(key.equals("updateUser")){
				adminMaintenance.getInstance().getUserbyId(request);
				roleMaintenance.getInstance().getAllRole(request);
				adminMaintenance.getInstance().getAllCountry(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addUser.jsp");
				
			}
			
			
			if(key.equals("country")){
				
				adminMaintenance.getInstance().getAllCountry(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/countryList.jsp");
				
			} 
			
			if(key.equals("state")){
				adminMaintenance.getInstance().getAllState(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/stateList.jsp");
				
			}
			
			if(key.equals("city")){
				adminMaintenance.getInstance().getAllCity(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/cityList.jsp");
				
			}
			
			if(key.equals("deleteState")){
				adminMaintenance.getInstance().deleteState(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/stateList.jsp");
				
			}
			
			if(key.equals("deleteCountry")){
				adminMaintenance.getInstance().deleteCountry(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/countryList.jsp");
			}
			
			if(key.equals("basics")){
				settingMaintenance.getInstance().getAllMaster(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/basicDetailsList.jsp");
			}
			
			if(key.equals("deleteBasic")){
				settingMaintenance.getInstance().deleteMaster(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/basicDetailsList.jsp");
			}
			
			
			if(key.equals("memberPlan")){
				memberMaintenance.getInstance().getAllMemberPlan(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberPlanList.jsp");
			}
			
			if(key.equals("deletePlan")){
				memberMaintenance.getInstance().deleteMemberPlan(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberPlanList.jsp");
			}
			
			if(key.equals("membersList")){
				memberMaintenance.getInstance().getAllMembers(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/membersList.jsp");
				
			}
			
			
			
		}
		rd=request.getRequestDispatcher("/index.jsp");  
		rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
