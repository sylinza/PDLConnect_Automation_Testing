package com.pdl.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class inputConfigurationReader {
	
	
	public static final Logger logger = LogManager.getLogger(inputConfigurationReader.class);
	private static Properties configFile;

	static {

		try {
			String path = "InputConfiguration.properties";
			FileInputStream input = new FileInputStream(path);

			configFile = new Properties();
			configFile.load(input);

			input.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}

}
