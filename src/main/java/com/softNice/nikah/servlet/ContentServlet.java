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

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.dashboardMaintenance;
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
				dashboardMaintenance.getInstance().getAllDashboardData(request);
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
			
			if(key.equals("galleryImage")){	
				
//				String relativeWebPath = "/images";
//				String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
//				System.out.println(absoluteDiskPath);
//				File[] directories = new File("D:/Sahil/Project/SoftNice_Hamara_Nikah/SoftNice_Hamara_Nikah/src/main/webapp/galleryImage").listFiles(File::isDirectory);
//				System.out.println(directories);
				
				
				File dir = new File("D:/Sahil/Project/SoftNice_Hamara_Nikah/SoftNice_Hamara_Nikah/src/main/webapp/galleryImage");
//			    File[] files = dir.listFiles();
//				FileFilter fileFilter = new FileFilter() {
//			         public boolean accept(File file) {
//			            return file.isDirectory();
//			         }
//			      };
//			     files = dir.listFiles(fileFilter);
//			     System.out.println(files.length);
			     getFilePath(dir);
			
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberGallery.jsp");
				
			}
			
			if(request.getParameter("key").equals("searchMember")){
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/searchMember.jsp");
				
			}
			
			
			
		}
		rd=request.getRequestDispatcher("/index.jsp");  
		rd.forward(request, response); 
	}

	private void getFilePath(File dir) {
		// TODO Auto-generated method stub
		 try { 
	         File[] files = dir.listFiles();
	         for (File file : files) {
	            if (file.isDirectory()) {
	               System.out.println("directory:" + file.getCanonicalPath());
	               getFilePath(file);
	            } else {
	               System.out.println("     file:" + file.getCanonicalPath());
	            } 
	         } 
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
