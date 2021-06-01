package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 */
	public ConfigReader() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * to get browser
	 * @return browser from property file
	 */
	public static String getBrowser() {
		return prop.getProperty("browser");
	}

	/**
	 * to get url
	 * @return url from property file
	 */
	public static String getURL() {
		return prop.getProperty("url");
	}

}
