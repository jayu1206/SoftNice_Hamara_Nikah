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
import com.softNice.nikah.beans.citiesBean;
import com.softNice.nikah.beans.countryBean;
import com.softNice.nikah.beans.masterBean;
import com.softNice.nikah.beans.permissionBean;
import com.softNice.nikah.beans.permissionnamesBean;
import com.softNice.nikah.beans.roleBean;
import com.softNice.nikah.beans.settingBean;
import com.softNice.nikah.beans.statesBean;



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

	public abstract boolean checkDublicateUserName(String str, int id);

	public abstract boolean checkDublicateEmail(String str, int id);

	public abstract boolean checkDublicatePhone(String str,int id);

	public abstract int insertUser(UserBean bean);

	public abstract UserBean getUserbyId(int parseInt);

	public abstract int updateUser(UserBean bean);

	public abstract UserBean loginUserAuth(String userName, String password);

	public abstract settingBean getSetting(String string);

	public abstract int updateSetting(settingBean bean);

	public abstract ArrayList<statesBean> getAllState();

	public abstract int insertCountry(countryBean bean);

	public abstract int insertMaster(masterBean bean);

	public abstract ArrayList<masterBean> getAllMasters();

	public abstract masterBean getMasterBaseonID(int parseInt);

	public abstract int deleteMaster(masterBean bean);

	public abstract boolean checkDublicateCountry(String fiels, String str);

	public abstract boolean checkDublicateState(int countryId, String state);

	public abstract int insertState(statesBean bean);

	public abstract statesBean getStateById(int parseInt);

	public abstract int deleteState(statesBean bean);

	public abstract countryBean getCountryById(int parseInt);

	public abstract int deleteCountry(countryBean bean);

	public abstract ArrayList<citiesBean> getAllCity();

	public abstract boolean checkDublicateCity(int stateId, String city);

	public abstract int insertCity(citiesBean bean);

	public abstract ArrayList<masterBean> getMasterBaseOnMasterID(int key);


}
