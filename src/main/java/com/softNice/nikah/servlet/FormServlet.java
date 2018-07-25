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
import java.util.logging.ErrorManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.roleMaintenance;

/**
 * Servlet implementation class FormServlet
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
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
			if(key.equals("addRole")){
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addRole.jsp");
				
			}
			if(key.equals("addUser")){
				adminMaintenance.getInstance().getAllCountry(request);
				roleMaintenance.getInstance().getAllRole(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addUser.jsp");
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
		String key=request.getParameter("key");
		RequestDispatcher rd = null;
		if(key!=null){
			if(key.equals("addRole")){
				
				ErrorMsg obj=(ErrorMsg) roleMaintenance.getInstance().validation(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addRole.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/roleList.jsp");
				}
				
			} //finish addRole
			
			if(key.equals("updateRole")){
				ErrorMsg obj=(ErrorMsg) roleMaintenance.getInstance().validationUpdate(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addRole.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/roleList.jsp");
				}
				
			} //finish updateRole
			
			if(key.equals("savePermission")){
				
				ErrorMsg obj=(ErrorMsg) roleMaintenance.getInstance().setPermission(request);
				request.setAttribute("error", obj);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/roleList.jsp");
				
			}
			
		}
		rd=request.getRequestDispatcher("/index.jsp");  
		rd.forward(request, response); 
	}

}
