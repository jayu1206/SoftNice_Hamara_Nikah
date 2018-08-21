package demo;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.softNice.nikah.utility.validation;

public class ObjectToJsonEx {
	
	 public static void main(String[] a){
         
		/* String uniqueID = UUID.randomUUID().toString();
		 
		 System.out.println(uniqueID.toUpperCase());
		 String str[]=uniqueID.split("-");
		 String userid=str[0];
		 System.out.println(userid.toUpperCase());
		
		 
		 int year = Calendar.getInstance().get(Calendar.YEAR);
		 System.out.println("year "+year);
		 */
	
		// HashMap newmap = new HashMap();

	      // populate hash map
	    /*  newmap.put(1, "tutorials");
	      newmap.put(2, "point");
	      newmap.put(3, "is best");*/

	      // check if map is empty
	    //  boolean val = newmap.isEmpty();

	      // check the boolean value
	    //  System.out.println("Is hash map empty: " + val);
	      /*  Employee emp = new Employee();
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
	        }*/
		 
		 Date dt=new Date();
		 System.out.println("dt : "+dt);
		 dt.setDate(dt.getDate()+10);
		 System.out.println("dt :"+dt);
		 
		 
		 
	    }

}
