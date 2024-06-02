package com.pdl.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class WindowUtil {
	public static void  openNewWindow(String url) throws AWTException {
		
	 String winHandleBefore = Driver.getDriver().getWindowHandle();

	    // Initialize the robot class object
	    Robot robot = new Robot();

	    // Press and hold Control and N keys
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_N);

	    // Release Control and N keys
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_N);

	    // Set focus to the newly opened browser window
	    ArrayList <String> tabs = new ArrayList<String> (Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs.get(tabs.size()-1));
	    for (String windowHandle : Driver.getDriver().getWindowHandles()) {
	    	CommonMethods.waitFor(3);
	    	Driver.getDriver().switchTo().window(windowHandle);
	    	CommonMethods.waitFor(3);
	    	
	    }

	    // Continue your actions in the new browser window
	    Driver.getDriver().get(url);
	}
	
	public static void originalBrowser() {
		ArrayList<String> tabs2 = new ArrayList<String> (Driver.getDriver().getWindowHandles());
	    
	    Driver.getDriver().switchTo().window(tabs2.get(0));
	    CommonMethods.waitFor(3);
	  
		
	}
	public static void secondBrowser() {
		ArrayList<String> tabs2 = new ArrayList<String> (Driver.getDriver().getWindowHandles());
	    Driver.getDriver().switchTo().window(tabs2.get(1));
	    
	}

}
