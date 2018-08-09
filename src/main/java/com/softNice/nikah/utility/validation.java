package com.softNice.nikah.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;


public class validation {
	
	static Logger log = Logger.getLogger(validation.class.getName()); 
	
	private static Pattern dateFrmtPtrn = 
            Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	
	private static Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	private static String regexStr = "^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$";
	
	public static SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy");
	
	public static boolean checkEmail(String str){
		
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(str);
		
		if (!matcher.matches()) {
			return false;
		}else{ 
			return true;
		}
		
	}
	
	public static boolean checkPhno(String str){
		
		
		Pattern pattern = Pattern.compile(regexStr);
	    Matcher matcher = pattern.matcher(str);
	    
	    if (!matcher.matches()) {
	    	return false;
	    } else{
	    	if(str.length()!=10){
	    		return false;
	    	}
	    	return true;
	    }
	    
	}
     
    public static boolean validateDateFormat(String userName){
         
        Matcher mtch = dateFrmtPtrn.matcher(userName);
        if(mtch.matches()){
            return true;
        }
        return false;
    }
    
    public static Date convertStringToDate(String s)
		{
			try
			{
				Date dt = ddmmyyyy.parse(s);
				return dt;
			}
			catch(Exception e)
			{
				log.log(Level.SEVERE, e.getMessage());
	   			e.printStackTrace();
			}
			return null;
		}
    
    public static String convertDateToString(Date dt)
  	{
    	String dtStr = "";
  		try
  		{
  			dtStr = ddmmyyyy.format(dt);
  			return dtStr;
  		}
  		catch(Exception e)
  		{
  			log.log(Level.SEVERE, e.getMessage());
  			e.printStackTrace();
  		}
  		return "";
  	}
    
    public static boolean isNumberFormate(String str){
    	try
  		{
  			int i = Integer.parseInt(str);
  			return true;
  		}
  		catch(NumberFormatException e)
  		{
  			return false;
  		}
    }

}
