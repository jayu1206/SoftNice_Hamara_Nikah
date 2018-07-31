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

package com.softNice.nikah.maintenance;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.constent.ErrorMsg;
import com.softNice.nikah.constent.contentPage;
import com.softNice.nikah.dao.administratorDAO;
import com.softNice.nikah.impl.administratorImpl;






public class roleMaintenance {
	
	static Logger log = Logger.getLogger(roleMaintenance.class.getName()); 
	
	 private static roleMaintenance roleObj;  
	 private roleMaintenance() {  }  
	
	 public static roleMaintenance getInstance() {    
         if (roleObj==null)  
       {  
        	 roleObj=new  roleMaintenance();  
       }  
         	return roleObj;  
	 }  
	 
	public Object validation(HttpServletRequest request){
		
		if (request.getParameter("txtRoleName") == null	|| request.getParameter("txtRoleName").trim().length() == 0){
			return new ErrorMsg(1, "Role name field is required");
		}
		
		roleBean bean=new roleBean();
		bean.setRoleName(request.getParameter("txtRoleName"));
		bean.setStatus(true);
		request.setAttribute("localObj", bean);
		
		administratorDAO dao=new administratorImpl();
		int flag=dao.checkDublicateName(bean);
		if(flag==0){
			flag = dao.insertRole(bean);
			if(flag!=0){
				return new ErrorMsg(2, "Internal Error");
			}
			
			ArrayList<roleBean> list=getAllRole(request);
			
		}else{
			if(flag==1){
				return new ErrorMsg(1, "Role name is exist");
			}else{
				return new ErrorMsg(2, "Internal Error");
			}
			
		}
		
		
		return new ErrorMsg(0, "Role created sucessfully");
	}
	
	
	public ArrayList<roleBean> getAllRole(HttpServletRequest request){
		administratorDAO dao=new administratorImpl();
		ArrayList<roleBean> list=dao.getAllRole();
		request.setAttribute("roleObj", list);
		return list;
	}

	public roleBean getRoleBaseOnId(HttpServletRequest request) {
		administratorDAO dao=new administratorImpl();
		roleBean bean=dao.getRoleBaseOnId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("modifyObj", bean);
		return bean;
		
	}
	
	public roleBean getRoleBaseOnId(int id) {
		administratorDAO dao=new administratorImpl();
		roleBean bean=dao.getRoleBaseOnId(id);
		//request.setAttribute("modifyObj", bean);
		return bean;
		
	}

	public ErrorMsg validationUpdate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if (request.getParameter("txtRoleName") == null	|| request.getParameter("txtRoleName").trim().length() == 0){
			return new ErrorMsg(1, "Role name field is required");
		}
		
		roleBean bean=new roleBean();
		bean.setRoleId(Integer.parseInt(request.getParameter("txtId")));
		bean.setRoleName(request.getParameter("txtRoleName"));
		bean.setStatus(true);
		request.setAttribute("localObj", bean);
		
		administratorDAO dao=new administratorImpl();
		int flag=dao.checkDublicateName(bean);
		if(flag==0){
			flag = dao.updateRole(bean);
			if(flag!=0){
				return new ErrorMsg(2, "Internal Error");
			}
			
			ArrayList<roleBean> list=getAllRole(request);
			
		}else{
			if(flag==1){
				return new ErrorMsg(1, "Role name is exist");
			}else{
				return new ErrorMsg(2, "Internal Error");
			}
			
		}
		
		
		return new ErrorMsg(0, "Role updated sucessfully");
	}

	public ErrorMsg deleteRole(HttpServletRequest request) {
		// TODO Auto-generated method stub
		administratorDAO dao=new administratorImpl();
		roleBean bean=dao.getRoleBaseOnId(Integer.parseInt(request.getParameter("id")));
		bean.setStatus(false);
		int flag = dao.updateRole(bean);
		if(flag!=0){
			return new ErrorMsg(2, "Internal Error");
		}
		
		ArrayList<roleBean> list=getAllRole(request);
		
		return new ErrorMsg(0, "Role Deleted sucessfully");
		
	}

	public ErrorMsg setPermission(HttpServletRequest request) {
		// TODO Auto-generated method stub
		permissionBean bean=null;
		administratorDAO dao=new administratorImpl();
		int flag = 0 ;
		ArrayList<permissionnamesBean> permissionNameList =(ArrayList<permissionnamesBean>) request.getSession().getAttribute(contentPage.PERMISSIONNAME);
		for(permissionnamesBean pName : permissionNameList){
			bean = new permissionBean();
			bean.setRoleId(Integer.parseInt(request.getParameter("roleId")));
			bean.setPermissionName(pName.getName());
			if(request.getParameter("chkAdd_"+pName.getId())!=null)
				bean.setAdd(true);
			else
				bean.setAdd(false);
			
			if(request.getParameter("chkUpdate_"+pName.getId())!=null)
				bean.setUpdate(true);
			else
				bean.setUpdate(false);
			
			if(request.getParameter("chkDelete_"+pName.getId())!=null)
				bean.setDelete(true);
			else
				bean.setDelete(false);
			
			if(request.getParameter("chkView_"+pName.getId())!=null)
				bean.setView(true);
			else
				bean.setView(false);
			
			
			permissionBean validateBean = dao.checkExistingPermisstion(bean);
			permissionBean bean2 = new permissionBean();
			bean2 = bean ;
			if(validateBean.getRoleId()!=0){
				
				bean2.setPermissionId(validateBean.getPermissionId());
				flag = dao.updatePermission(bean2);
			}else{
				flag = dao.insertPermission(bean2);
				
			}
			
			
			if(flag!=0){
				return new ErrorMsg(2, "Internal Error");
			}
		}

		ArrayList<roleBean> list=getAllRole(request);
		
		
		return new ErrorMsg(0, "Permission save sucessfully");
	}

	

}
