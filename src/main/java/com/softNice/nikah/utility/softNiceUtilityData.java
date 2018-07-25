package com.softNice.nikah.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.softNice.nikah.database.HibernateFactory;





public class softNiceUtilityData {
	
	static Logger log = Logger.getLogger(softNiceUtilityData.class.getName());
	
	private int code;
	private String Name;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	} 
	
	public softNiceUtilityData(){
		HibernateFactory.buildIfNeeded();
	}
	
	public static Map  getState(int countryID){
		   ArrayList<softNiceUtilityData> listData =  new  ArrayList<softNiceUtilityData>();
		   Session session= null;
		try{
			
			session = HibernateFactory.openSession();
			softNiceUtilityData imoData = null;
			session.setDefaultReadOnly(true);
			List list = session.createQuery("SELECT  id,name  FROM  statesBean where status=1 and countryId="+countryID+" " ).list();
			Iterator ite = list.iterator();
			if(list !=null  && list.size() > 0){
				  for(int i=0;i<list.size();i++){
					  if(ite.hasNext()){
						  Object [] objectBu = (Object []) ite.next();
						  imoData = new softNiceUtilityData();
						  imoData.setCode((Integer)objectBu[0]);
						  imoData.setName((String)objectBu[1]);
						  
						  listData.add(imoData);
						  
					  }
				  }
			}
			}catch(HibernateException e)
			{
				log.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}finally{
				try{
					HibernateFactory.close(session);
					
				}catch(Exception e){
					log.log(Level.SEVERE, e.getMessage());
					e.printStackTrace();
				}
		}
		Map map=new HashMap();
	    map.put("list",listData);
	    
	      return map;  
	}
	
	public static Map  getCity(int stateID){
		   ArrayList<softNiceUtilityData> listData =  new  ArrayList<softNiceUtilityData>();
		   Session session= null;
		try{
			
			session = HibernateFactory.openSession();
			softNiceUtilityData imoData = null;
			session.setDefaultReadOnly(true);
			List list = session.createQuery("SELECT  id,name  FROM  citiesBean where status=1 and stateId="+stateID+" " ).list();
			Iterator ite = list.iterator();
			if(list !=null  && list.size() > 0){
				  for(int i=0;i<list.size();i++){
					  if(ite.hasNext()){
						  Object [] objectBu = (Object []) ite.next();
						  imoData = new softNiceUtilityData();
						  imoData.setCode((Integer)objectBu[0]);
						  imoData.setName((String)objectBu[1]);
						  
						  listData.add(imoData);
						  
					  }
				  }
			}
			}catch(HibernateException e)
			{
				log.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}finally{
				try{
					HibernateFactory.close(session);
					
				}catch(Exception e){
					log.log(Level.SEVERE, e.getMessage());
					e.printStackTrace();
				}
		}
		Map map=new HashMap();
	    map.put("list",listData);
	    
	      return map;  
	}

}
