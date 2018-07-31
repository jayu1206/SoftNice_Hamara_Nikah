package demo;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;

public class ObjectToJsonEx {
	
	 public static void main(String[] a){
         
	        Employee emp = new Employee();
	        ObjectMapper mapperObj = new ObjectMapper();
	         
	        try {
	            // get Employee object as a json string
	            String jsonStr = mapperObj.writeValueAsString(emp);
	            System.out.println(jsonStr);
	            
	            String str= "Application © 2013-2014";
	            
	            System.out.println(str);
	            
	            emp = new Gson().fromJson(jsonStr,Employee.class);
	            
	            System.out.println("id :"+emp.getEmpId());
	            System.out.println("name :"+emp.getName());
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

}
