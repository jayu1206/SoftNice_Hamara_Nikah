package com.softNice.nikah.beans;

import java.util.Date;

public class memberPlanBean {
	private int planId;
	private String planName;
	private int credits;
	private int planValidity;
	private int planCharges;
	private int order;
	private boolean printedView;
	private boolean photoUpload;
	private boolean horoscopeUpload;
	private boolean horoscopeView;
	private boolean videoUpload;
	private boolean protectPhoto;
	private boolean bookmark;
	private boolean messaging;
	private boolean serviceTex;
	private boolean status;
	private String createdBy;
	private Date creationDate;
	
	
	public memberPlanBean(){
		
		planId = 0;
		planName = "";
		credits = 0;
		planValidity = 0;
		planCharges = 0;
		order = 0;
		/*printedView = false;
		photoUpload = false;
		horoscopeUpload = false;
		horoscopeView = false;
		videoUpload = false;
		protectPhoto =false;
		bookmark =false;
		messaging = false;
		serviceTex =false;
		status =  false;*/
		createdBy = "";
		creationDate = null;
		
		
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getPlanValidity() {
		return planValidity;
	}
	public void setPlanValidity(int planValidity) {
		this.planValidity = planValidity;
	}
	public int getPlanCharges() {
		return planCharges;
	}
	public void setPlanCharges(int planCharges) {
		this.planCharges = planCharges;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public boolean isPrintedView() {
		return printedView;
	}
	public void setPrintedView(boolean printedView) {
		this.printedView = printedView;
	}
	public boolean isPhotoUpload() {
		return photoUpload;
	}
	public void setPhotoUpload(boolean photoUpload) {
		this.photoUpload = photoUpload;
	}
	public boolean isHoroscopeUpload() {
		return horoscopeUpload;
	}
	public void setHoroscopeUpload(boolean horoscopeUpload) {
		this.horoscopeUpload = horoscopeUpload;
	}
	public boolean isHoroscopeView() {
		return horoscopeView;
	}
	public void setHoroscopeView(boolean horoscopeView) {
		this.horoscopeView = horoscopeView;
	}
	public boolean isVideoUpload() {
		return videoUpload;
	}
	public void setVideoUpload(boolean videoUpload) {
		this.videoUpload = videoUpload;
	}
	public boolean isProtectPhoto() {
		return protectPhoto;
	}
	public void setProtectPhoto(boolean protectPhoto) {
		this.protectPhoto = protectPhoto;
	}
	public boolean isBookmark() {
		return bookmark;
	}
	public void setBookmark(boolean bookmark) {
		this.bookmark = bookmark;
	}
	public boolean isMessaging() {
		return messaging;
	}
	public void setMessaging(boolean messaging) {
		this.messaging = messaging;
	}
	public boolean isServiceTex() {
		return serviceTex;
	}
	public void setServiceTex(boolean serviceTex) {
		this.serviceTex = serviceTex;
	}
	
	

}
