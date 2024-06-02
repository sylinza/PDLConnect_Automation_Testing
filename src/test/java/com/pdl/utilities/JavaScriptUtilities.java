package com.pdl.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {

	public static void jsclick(WebDriver driver,WebElement element) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click()", element);
	}
	
     public static void SelectDateByJS(WebDriver driver,WebElement element,String Datevalue) {		
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].setAttribute('value','"+Datevalue+"')", element);
		
	}
     
     public static void scrollIntoView(WebDriver driver,WebElement element) {		
 		JavascriptExecutor js = (JavascriptExecutor)driver;		
 		js.executeScript("arguments[0].scrollIntoView(true);", element);
 		
 	}
     
     
     public static void scrollbottom(WebDriver driver) {		
  		JavascriptExecutor js = (JavascriptExecutor)driver;		
  		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
  		
  	}
     
     public static void changecolour(String color,WebElement element,WebDriver driver) {
    	 
    		JavascriptExecutor js = (JavascriptExecutor)driver;	
    		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
    		try {
    			Thread.sleep(200);
    		}
    		catch (Exception e) {
				e.printStackTrace();
			} }
     
        public static void flash(WebElement element,WebDriver driver) {
        	
        	String bgcolor= element.getCssValue("backgroundColor");
        	System.out.println(bgcolor);
        	
        	for(int i=0;i<20;i++) {
        		changecolour("#0000FF", element, driver);
        		changecolour(bgcolor, element, driver);
        	}}
        
        
        public static void drawborder(WebElement element, WebDriver driver) {
        	JavascriptExecutor js = (JavascriptExecutor)driver;	
    		js.executeScript("arguments[0].style.border='3px solid green'", element);
    		
    	
    		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
        }
        
        public static void generateAlert(WebDriver driver,String message) {
        	JavascriptExecutor js= (JavascriptExecutor)driver;
        	js.executeScript("alert('"+message+"')");
        	
        	
        }
	
}
