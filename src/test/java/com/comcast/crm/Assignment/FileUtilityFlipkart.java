package com.comcast.crm.Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilityFlipkart {
	
	public String getDataFromPropertyFile(String key) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\abkmo\\OneDrive\\Documents\\DDt Excel\\flipkart.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		
	}

}
