package com.pdl.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigirationReader_Invoice_Rate {

	
	private static Properties configFile;

	static {

		try {
			String path = "src/test/resources/features/Rate_Generation/Configuration_InputsForInvoiceAndRateGen.properties";
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
