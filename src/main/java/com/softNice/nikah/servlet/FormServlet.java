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
import java.io.IOException;
import java.util.List;
import java.util.logging.ErrorManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.softNice.nikah.beans.generalSettingBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.maintenance.adminMaintenance;
import com.softNice.nikah.maintenance.roleMaintenance;
import com.softNice.nikah.maintenance.settingMaintenance;

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
			
			if(key.equals("generalSetting")){
				settingBean bean= settingMaintenance.getInstance().getSetting("general_setting", request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/general.jsp");
				
			}
			
			if(key.equals("emailSetting")){
				settingBean bean= settingMaintenance.getInstance().getSetting("email_setting", request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/email.jsp");
			}
			
			if(key.equals("addCountry")){
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addCountry.jsp");
				
			}
			//
			if(key.equals("addState")){
				adminMaintenance.getInstance().getAllCountry(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addState.jsp");
				
			}
			
			if(key.equals("addBasics")){
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addBasicDetails.jsp");
				
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
			
			if(key.equals("addCountry")){
				ErrorMsg obj=(ErrorMsg) adminMaintenance.getInstance().validationCountry(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addCountry.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/countryList.jsp");
				}
			}
			
			if(key.equals("addState")){
				ErrorMsg obj=(ErrorMsg) adminMaintenance.getInstance().validationState(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addState.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/stateList.jsp");
				}
				
			}
			
			if(key.equals("savePermission")){
				
				ErrorMsg obj=(ErrorMsg) roleMaintenance.getInstance().setPermission(request);
				request.setAttribute("error", obj);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/roleList.jsp");
				
			}
			
			
			if(key.equals("addUser")){
				ErrorMsg obj=(ErrorMsg) adminMaintenance.getInstance().addvalidation(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addUser.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/userList.jsp");
				}
				
			} 
			
			if(key.equals("updateUser")){
				
				ErrorMsg obj=(ErrorMsg) adminMaintenance.getInstance().updateValidation(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/addUser.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/userList.jsp");
				}
				
			}
			
			if(key.equals("updateSetting")){
				generalSettingBean bean=new generalSettingBean();
				ServletContext servletContext = this.getServletConfig().getServletContext();
				 if(ServletFileUpload.isMultipartContent(request)){
			            try {
			                List<FileItem> multiparts = new ServletFileUpload(
			                                         new DiskFileItemFactory()).parseRequest(request);
			              
			                for(FileItem item : multiparts){
			                    if(!item.isFormField()){
			                    	if(new File(item.getName()).getName().length()>0){
			                    		String name = new File(item.getName()).getName();
				                        String tempDir = servletContext.getRealPath(File.separator)+  "image" ;
				                       // String tempDir2 = servletContext.getResource(File.separator)+ "resources" + File.separator+ "image" ;
				                        File uploadedFile1 = new File(tempDir);
										 if(!uploadedFile1.exists())
											 uploadedFile1.mkdirs();
										 String withFile = tempDir  + File.separator+ name;
										 File uploadedFile = new File(withFile);
										 item.write(uploadedFile);
										 bean.setLogo(withFile);
			                    	}
			                        
									 
			                    }
			                    else{
			                    	if(item.getFieldName().equals("txtAppName")){
			                    		//System.out.println(item.getString());
			                    		bean.setApp_name(item.getString());
			                    	}
			                    	if(item.getFieldName().equals("txtCopyRight")){
			                    		bean.setCopyRight(item.getString());
			                    	}
			                    	
			                    }
			                }
			           
			                ErrorMsg obj=(ErrorMsg) settingMaintenance.getInstance().updateGeneral(bean,request);
			                request.setAttribute("error", obj);
							request.setAttribute(contentPage.CONTENT_PAGE, "/setting/general.jsp");
			            } catch (Exception ex) {
			            	ex.printStackTrace();
			            }          
			         
			        }else{
			            request.setAttribute("message",
			                                 "Sorry this Servlet only handles file upload request");
			        }
				 
				
			}
			 
			if(key.equals("emailSetting")){
				ErrorMsg obj=(ErrorMsg) settingMaintenance.getInstance().updateEmail(request);
				request.setAttribute("error", obj);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/email.jsp");
				
			}
			if(key.equals("addBasics")){
				ErrorMsg obj=(ErrorMsg) settingMaintenance.getInstance().validateMaster(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addBasicDetails.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/basicDetailsList.jsp");
				}
			}
			
			
		}
		rd=request.getRequestDispatcher("/index.jsp");  
		rd.forward(request, response); 
	}

}
