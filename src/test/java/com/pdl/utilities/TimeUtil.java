package com.pdl.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
	public static String getCurrentTime() {
		 long millis=System.currentTimeMillis();
			java.util.Date date=new java.util.Date(millis);
			//logger.info(date);
			String time=""+date;
	return time;
	}
	public static String todayDate( ) {    
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   dtf= DateTimeFormatter.ofPattern( "MM/dd/yyyy");
		   LocalDateTime now = LocalDateTime.now();  
		   String date =dtf.format(now);
		  // logger.info(dtf.format(now));  
		   return date;
		  }  
	
}
