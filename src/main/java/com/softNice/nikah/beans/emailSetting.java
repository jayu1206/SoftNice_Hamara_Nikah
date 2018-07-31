package com.softNice.nikah.beans;

public class emailSetting {
	private String email_type;
	private String server_name;
	private String userName;
	private String password;
	private String port;
	
public	emailSetting(){
		email_type="";
		server_name="";
		userName="";
		password="";
		port="";
	}
	
	public String getEmail_type() {
		return email_type;
	}
	public void setEmail_type(String email_type) {
		this.email_type = email_type;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	

}
