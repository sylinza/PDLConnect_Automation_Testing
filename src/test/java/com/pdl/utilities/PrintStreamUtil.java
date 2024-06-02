package com.pdl.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//import cucumber.api.Scenario;
import io.cucumber.java.Scenario;

public class PrintStreamUtil  {
	public static final Logger logger = LogManager.getLogger(PrintStreamUtil.class);


	
public static File file= new File(ConfigurationReader.getProperty("testingDataFile"));
public static PrintStream o;
public static PrintStream console = System.out;

	
	public static PrintStream appendFile(String appendText) {
		 try {
			o = new PrintStream(file);
		} catch (FileNotFoundException e) {
			
		}
		System.setOut(o);
	
		o.append(appendText);

	return o;
	}

public static PrintStream printStreamConsule() {
		//File file= new File(fileTxt);
		try {
			
			 console = new PrintStream(file);
		} catch (FileNotFoundException e) {
			
		}
	return console;
	}
}
