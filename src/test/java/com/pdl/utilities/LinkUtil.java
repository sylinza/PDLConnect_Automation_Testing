package com.pdl.utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkUtil {
	
	public static final Logger logger = LogManager.getLogger(LinkUtil.class);
	
	
	
	
	
	public static void clickLinkByHref(String href, String id) {
        List<WebElement> anchors = Driver.getDriver().findElements(By.tagName("a"));
       logger.info(anchors);
        
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href) && anchor.getAttribute("id").contains(id)){
            	anchor.click();
                break;
            }
        }
    }

}
