package com.softNice.nikah.beans;

import java.util.Date;

public class orderBean {
	
	private int id;
	private String memberId;
	private Date startDate;
	private Date endDate;
	private String createdBy;
	private Date creationDate;
	private int memberPlanId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getMemberPlanId() {
		return memberPlanId;
	}
	public void setMemberPlanId(int memberPlanId) {
		this.memberPlanId = memberPlanId;
	}
	
	
	
	

}
