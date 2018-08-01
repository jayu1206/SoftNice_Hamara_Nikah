package com.softNice.nikah.beans;

public class countryBean {
	
	private int id;
	private String sortname;
	private String name;
	private int phonecode;
	private boolean status;
	
	
	public countryBean(){
		sortname = "";
		name = "";
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sorftname) {
		this.sortname = sorftname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhonecode() {
		return phonecode;
	}
	public void setPhonecode(int phonecode) {
		this.phonecode = phonecode;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
		

}
