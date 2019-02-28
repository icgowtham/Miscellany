package com.eroad.assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	public static String parseAndSendDataFromJSON (String jsonString) {
		if ("".equals (jsonString) || jsonString == null) {
			return null;
		}

		JSONParser parser = new JSONParser();
		String output = null;

		try {
			Object obj = parser.parse (jsonString);
			JSONObject jsonObject = (JSONObject) obj;

			String timezoneId = (String) jsonObject.get("timezoneId");
			String time = (String) jsonObject.get("time");

			output = timezoneId + ", " + time;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}
}