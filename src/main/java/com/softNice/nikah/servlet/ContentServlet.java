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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.softNice.nikah.beans.memberStoryBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.dao.memberDAO;
import com.softNice.nikah.impl.memberImpl;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.dashboardMaintenance;
import com.softNice.nikah.maintenance.memberMaintenance;
import com.softNice.nikah.maintenance.roleMaintenance;
import com.softNice.nikah.maintenance.settingMaintenance;
import com.softNice.nikah.utility.validation;

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

			if(request.getParameter("key").equals("order")){
				memberMaintenance.getInstance().getAllMemberPlan(request);
				memberMaintenance.getInstance().getAllActiveMembers(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/orderMember.jsp");
			}
			
			if(request.getParameter("key").equals("viewMember")){
				
				memberMaintenance.getInstance().getMemberById(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberProfile.jsp");
				
			}
			
			if(request.getParameter("key").equals("addStory")){
				
				adminMaintenance.getInstance().getAllCountry(request);
				memberMaintenance.getInstance().getMemberById(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberStory.jsp");
				
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
		
		String key=request.getParameter("key");
		RequestDispatcher rd = null;
		if(key!=null){
			if(request.getParameter("key").equals("searchMember")){
				
				adminMaintenance.getInstance().seachMember(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/searchMember.jsp");
				
			}
			
if(request.getParameter("key").equals("addMemberStory")){
				

				memberStoryBean bean= new memberStoryBean();
				ServletContext servletContext = this.getServletConfig().getServletContext();
				 if(ServletFileUpload.isMultipartContent(request)){
			            try {
			                List<FileItem> multiparts = new ServletFileUpload(
			                                         new DiskFileItemFactory()).parseRequest(request);
			              
			                for(FileItem item : multiparts){
			                    if(!item.isFormField()){
			                    	if(new File(item.getName()).getName().length()>0){
			                    		String name = new File(item.getName()).getName();
			                    		
			                    		final String IMAGE_RESOURCE_PATH = "/webapp/temp";
			                    		
			                    		String directoryPath = 
			                    		        getServletContext().getRealPath(IMAGE_RESOURCE_PATH);
			                    		
			                    		File directory = new File(directoryPath);

			                    		if(!directory.exists()) {
			                    		    directory.mkdirs();
			                    		}
			                    		
										 String withFile = directoryPath  + File.separator+ name;
										 File uploadedFile = new File(withFile);
										 if(!uploadedFile.exists())
											 uploadedFile.createNewFile();
										 item.write(uploadedFile);
										 bean.setImgUrl(withFile);
			                    	}
			                        
									 
			                    }
			                    else{
			                    	if(item.getFieldName().equals("txtBrideName")){
			                    		//System.out.println(item.getString());
			                    		bean.setBrideName(item.getString());
			                    	}
			                    	if(item.getFieldName().equals("txtGroomName")){
			                    		bean.setGroomName(item.getString());
			                    	}
			                    	if(item.getFieldName().equals("txtMemberId")){
			                    		bean.setMemberId(item.getString());
			                    	}
			                    	if(item.getFieldName().equals("txtPartnerMemberId")){
			                    		//System.out.println(item.getString());
			                    		bean.setPartnerMemberId(item.getString());			                    		
			                    	}
			                    	if(item.getFieldName().equals("txtEngDate")){
			                    		bean.setEngDate(validation.convertStringToDate(item.getString()));			                    		
			                    	}
			                    	if(item.getFieldName().equals("txtMarriageDate")){
			                    		bean.setMarriageDate(validation.convertStringToDate(item.getString()));
			                    	}
			                    	if(item.getFieldName().equals("txtEmail")){			                    		
			                    		bean.setEmail(item.getString());	
			                    	}
			                    	if(item.getFieldName().equals("txtAddress")){
			                    		bean.setAddress(item.getString());
			                    	}
			                    	if(item.getFieldName().equals("country")){
			                    		bean.setCountry(item.getString());
			                    	}
			                    	/*if(item.getFieldName().equals("txtCountryCode")){			                    		
			                    		bean.setAddress(item.getString());
			                    	}*/
			                    	if(item.getFieldName().equals("txtPhone")){
			                    		bean.setPhone(item.getString());
			                    	}
			                    	if(item.getFieldName().equals("txtSussessStory")){
			                    		bean.setSuccessStory(item.getString());
			                    	}
			                    }
			                }
			           
			                ErrorMsg obj=(ErrorMsg) memberMaintenance.getInstance().insertMemberStory(bean,request);
			                request.setAttribute("error", obj);
			                if(obj.getErrorCode()!=0){		
			                	memberMaintenance.getInstance().getAllStories(request);
			    				request.getSession().setAttribute(contentPage.STORIES, getServletContext().getAttribute(contentPage.STORIES));
			                	request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberStory.jsp");
			                	//rd=request.getRequestDispatcher("/member/memberStory.jsp");
							}else{
								request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberStory.jsp");
								//rd=request.getRequestDispatcher("/member/memberStory.jsp");
							}
							rd.forward(request, response); 
			            } catch (Exception ex) {
			            	ex.printStackTrace();
			            }          
			         
			        }
			
				
//				ErrorMsg obj=(ErrorMsg) memberMaintenance.getInstance().addMemberStory(request);
//				request.setAttribute("error", obj);				
//				rd=request.getRequestDispatcher("/MemberLogin.jsp");  
//				rd.forward(request, response); 
				
			}
		
		}
		
		rd=request.getRequestDispatcher("/index.jsp");  
		rd.forward(request, response); 
	}

}
