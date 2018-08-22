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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.softNice.nikah.maintenance.memberMaintenance;
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
				
				HashMap<Integer, String> map = new HashMap<Integer, String>();
				if(request.getSession().getAttribute(contentPage.MASTERMAPOBJ)!=null){
					map = (HashMap<Integer, String>)  request.getSession().getAttribute(contentPage.MASTERMAPOBJ);
					for(Map.Entry m:map.entrySet()){
						adminMaintenance.getInstance().getMasterBaseOnId((int)m.getKey(),m.getValue().toString(),request);
						
					}
				}
				
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
			
			if(key.equals("addCity")){
				adminMaintenance.getInstance().getAllCountry(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addCity.jsp");
			}
			
			if(key.equals("addMemberPlan")){
				request.setAttribute(contentPage.CONTENT_PAGE, "/member/addMemberPlan.jsp");
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
			                    		
			                    		final String IMAGE_RESOURCE_PATH = "/webapp/images";
			                    		
			                    		String directoryPath = 
			                    		        getServletContext().getRealPath(IMAGE_RESOURCE_PATH);
			                    		//String temp = getServletContext().getContextPath()+IMAGE_RESOURCE_PATH + File.separator ;
			                    		//String temp2 = request.getServletContext().getRealPath("")+IMAGE_RESOURCE_PATH + File.separator;
			                    		File directory = new File(directoryPath);

			                    		if(!directory.exists()) {
			                    		    directory.mkdirs();
			                    		}
			                    		
			                    		
				                        /*String tempDir = servletContext.getRealPath(File.separator)+  "image" ;
				                       // String tempDir2 = servletContext.getResource(File.separator)+ "resources" + File.separator+ "image" ;
				                        File uploadedFile1 = new File(tempDir);
										 if(!uploadedFile1.exists())
											 uploadedFile1.mkdirs();*/
										 String withFile = directoryPath  + File.separator+ name;
										 File uploadedFile = new File(withFile);
										 if(!uploadedFile.exists())
											 uploadedFile.createNewFile();
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
			                    	if(item.getFieldName().equals("txtCmpName")){
			                    		bean.setCmpName(item.getString());
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
			
			if(key.equals("addCity")){
				ErrorMsg obj=(ErrorMsg) adminMaintenance.getInstance().validationCity(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/addCity.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/setting/cityList.jsp");
				}
			}
			
			if(key.equals("addMemberPlan")){
				
				ErrorMsg obj=(ErrorMsg) memberMaintenance.getInstance().validationMemberPlan(request);
				request.setAttribute("error", obj);
				if(obj.getErrorCode()!=0){
					request.setAttribute(contentPage.CONTENT_PAGE, "/member/addMemberPlan.jsp");
				}else{
					request.setAttribute(contentPage.CONTENT_PAGE, "/member/memberPlanList.jsp");
				}
			}
			if(key.equals("addOrder")){
				
				
				ErrorMsg obj=(ErrorMsg) memberMaintenance.getInstance().validationForOrder(request);
				request.setAttribute("error", obj);
				memberMaintenance.getInstance().getAllMemberPlan(request);
				memberMaintenance.getInstance().getAllActiveMembers(request);
				request.setAttribute(contentPage.CONTENT_PAGE, "/administrator/orderMember.jsp");
				/*System.out.println("memberId "+request.getParameter("memberId"));
				System.out.println("planId "+request.getParameter("planId"));
				System.out.println("txtStartDate "+request.getParameter("txtStartDate"));
				System.out.println("txtEndDate "+request.getParameter("txtEndDate"));*/
				
			}
			
			
			
			
		}
		rd=request.getRequestDispatcher("/index.jsp");  
		rd.forward(request, response); 
	}

}
