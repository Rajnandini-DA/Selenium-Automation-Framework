package com.comcost.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * JsonUtility class:
 * Provides reusable methods to read data from JSON files.
 */




public class JSONUtility {


    /*
     * Loads a JSON file from the given file path.
     */
	
	public String getDatafromJSONFile(String key) throws IOException, ParseException {
		
		FileReader fileR = new FileReader("C:\\Users\\abkmo\\OneDrive\\Documents\\DDt Excel\\commondataJson.json");
		JSONParser parser = new JSONParser();
		Object Object = parser.parse(fileR);
		JSONObject map = (JSONObject)Object;
		String data = (String) map.get(key);
		
		return data;
	}
}
