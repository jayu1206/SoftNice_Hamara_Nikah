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

package com.softNice.nikah.dao;

import java.util.ArrayList;

import com.softNice.nikah.beans.UserBean;
import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.beans.roleBean;



public interface administratorDAO {
	

	public abstract int checkDublicateName(roleBean bean);

	public abstract int insertRole(roleBean bean);

	public abstract ArrayList<roleBean> getAllRole();
	
	public abstract roleBean getRoleBaseOnId(int id);

	public abstract int updateRole(roleBean bean);
	
	public abstract ArrayList<permissionnamesBean> getAllPermissionName();

	public abstract int insertPermission(permissionBean bean);

	public abstract permissionBean checkExistingPermisstion(permissionBean bean);

	public abstract int updatePermission(permissionBean bean);
	
	public abstract permissionBean getExistingPermisstion(int id,permissionnamesBean bean);
	
	public abstract ArrayList<UserBean> getAllUsers();

	public abstract ArrayList<countryBean> getAllCountry();


}
