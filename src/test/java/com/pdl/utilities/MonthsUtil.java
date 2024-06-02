package com.pdl.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MonthsUtil {
	public static String monthNum;
	public static final Logger logger = LogManager.getLogger(MonthsUtil.class); 
	
	
	public  static String convertDate(String Date){
		//from 19-Jan-2022 to 01/19/2022
	 
		
		String month= Date.substring(Date.indexOf("-")+1, Date.indexOf("-")+1+3);
		month= month.toUpperCase();
		logger.info(month);
		
		switch (month) {
		 case "JAN":  
			   monthNum="01";
			 break;
		 case "FEB":   
			 monthNum="02";
			 break;
		 case "MAR":   
			 monthNum="03";
			 break;
		 case "APR":   
			 monthNum="04";
			 break;
		 case "MAY":   
			 monthNum="05";
			 break;
		 case "JUN":   
			 monthNum="06";
			 break;
		 case "JUL":   
			 monthNum="07";
			 break;
		 case "AUG":   
			 monthNum="08";
			 break;
		 case "SEP":   
			 monthNum="09";
			 break;
		 case "OCT":   
			 monthNum="10";
			 break;
			 
		 case "NOV":   
			 monthNum="11";
			 break;
		 case "DEC":   
			 monthNum="12";
			 break;

}
		String dateNew="";
		 
		if(Date.length()==18) {
			dateNew= monthNum+"/"+Date.substring(0, 2)+"/"+Date.substring((Date.indexOf(" ")-2),Date.indexOf(" "));
			
		}else {
	 dateNew= monthNum+"/"+Date.substring(0, 2)+"/"+Date.substring(Date.length()-4, Date.length());
	 
		}
	
	 
	
	return dateNew;
	}

public  static String convertTodayDate(){
		//from  01/19/2022 to 19-Jan-2022 
		String todayDate=todayDate();
	   String monthNumber=todayDate.substring(0, 2);
		 
		switch (monthNumber) {
		 case "01":  
			   monthNum="JAN";
			 break;
		 case "02":   
			 monthNum="FEB";
			 break;
		 case "03":   
			 monthNum="MAR";
			 break;
		 case "04":   
			 monthNum="APR";
			 break;
		 case "05":   
			 monthNum="MAY";
			 break;
		 case "06":   
			 monthNum="JUN";
			 break;
		 case "07":   
			 monthNum="JUL";
			 break;
		 case "08":   
			 monthNum="AUG";
			 break;
		 case "09":   
			 monthNum="SEP";
			 break;
		 case "10":   
			 monthNum="OCT";
			 break;
			 
		 case "11":   
			 monthNum="NOV";
			 break;
		 case "12":   
			 monthNum="DEC";
			 break;

}
		String dateNew="";	
		//from  01/19/2022 to 19-Jan-2022 
		String day=todayDate.substring((todayDate.indexOf("/")+1), (todayDate.indexOf("/")+3)); 
	    int lengthOfTheDate=todayDate.length();
		String year= todayDate.substring(lengthOfTheDate-4, lengthOfTheDate);
		dateNew=day+"/"+monthNum+"/"+year; 

	return dateNew;
	}
	
	
	
	
	
	public static String todayDate() {
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		// logger.info("Today date: "+date1);
		 return date1;
		 }
	
	public static String todayDateFormat2() {
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		// logger.info("Today date: "+date1);
		 return date1;
		 }
	
	public static String dateWithTimeToDateWithSlashes(String DateWithTime) {
		// form 2021-12-17 00:00:00.0
		// to 12/17/2021
		String year=DateWithTime.substring(0, 4);
		String month=DateWithTime.substring(5, 7);
		String day=DateWithTime.substring(8, 10);
		String date =(month+"/"+day+"/"+year);
		return date;
	}
	
}
