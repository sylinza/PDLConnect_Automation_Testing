package com.pdl.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import org.apache.commons.io.FileUtils;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//import cucumber.api.java.en.Given;

public class FileUtil {
	public static final Logger logger = LogManager.getLogger(FileUtil.class);

	/**
	 * returns the newest file path from the downloads folder
	 * 
	 * @return filepath
	 */
	public static String getMostRecentFileFromDownloads() {
		Path downloads = Paths.get(System.getProperty("user.home") + "/Downloads");
		Optional<File> mostRecentFile = Arrays.stream(downloads.toFile().listFiles()).filter(f -> f.isFile())
				.max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));
       CommonMethods.waitFor(20);
		return mostRecentFile.get().getAbsolutePath();
//C:\Users\petrosjanatwifordg\Downloads\Cash Receipt Detail ad6d0895b.xlsx
	}

	/**
	 * Quietly deletes the file given path
	 * 
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path) {
		File fileToDelete = FileUtils.getFile(path);
		return FileUtils.deleteQuietly(fileToDelete);
	}
	public static String  getTextFile() {
		Path downloads = Paths.get("C:\\Users\\petrosjanatwifordg\\git\\eRebate_Automation10\\TestResults.txt");
	String failName=	downloads.getFileName().toString();
	logger.info("failName from util class "+failName);
		return failName;
	}
	
	public static void readTextFileUsingBufferdReader(String fileName) { 
		try { 
			FileReader textFileReader = new FileReader(fileName); 
		BufferedReader bufReader = new BufferedReader(textFileReader); 
		char[] buffer = new char[8096]; 
		int numberOfCharsRead = bufReader.read(buffer); // read will be from 
		// memory
		while (numberOfCharsRead != -1) {
			logger.info(String.valueOf(buffer, 0, numberOfCharsRead));
			numberOfCharsRead = textFileReader.read(buffer); 
			} 
		bufReader.close(); 
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		
		}
	}

	
	
	
}
