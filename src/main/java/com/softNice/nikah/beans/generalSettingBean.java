package com.softNice.nikah.beans;

public class generalSettingBean {
	private String app_name;
	private String logo;
	private String copyRight;
	
	public generalSettingBean(){
		app_name = "";
		copyRight="";
		logo = "";
	}
	
	public String getApp_name() {
		return app_name;
	}
	
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	
	

}
