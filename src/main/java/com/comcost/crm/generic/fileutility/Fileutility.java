package com.comcost.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * FileUtility class:
 * Provides reusable methods to read and write data from property files.
 */

public class Fileutility {

	 /*
     * Loads the property file from the given file path.
     */
	public String getDatafromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		return data;
	}
	
}
