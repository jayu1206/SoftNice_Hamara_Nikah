package com.softNice.nikah.dao;

import java.util.ArrayList;

import com.softNice.nikah.beans.memberBean;
import com.softNice.nikah.beans.memberDetailsBean;
import com.softNice.nikah.beans.memberPlanBean;

public interface memberDAO {

	public abstract ArrayList<memberPlanBean> getAllPlan();

	public abstract int insertMemberPlan(memberPlanBean bean);

	public abstract memberPlanBean getMemberPlanById(int parseInt);

	public abstract int deleteMemberPlan(memberPlanBean bean);

	public abstract memberBean loginMemberAuth(String userName, String password);

	public abstract boolean checkDublicateEmail(String str, int id);

	public abstract memberPlanBean getFreeMembershipPlan();

	public abstract int newRegisterMember(memberBean bean);

	public abstract memberBean getMemberBaseOnId(int parseInt);

	public abstract int insertMemberDetails(memberDetailsBean details);

	public abstract ArrayList<memberBean> getAllMembers();

	public abstract boolean checkDublicatePhone(String str, int id);

	public abstract int updateMember(memberBean bean);

}
