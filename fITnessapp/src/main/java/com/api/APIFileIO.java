package com.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class APIFileIO {
	protected static void writeToWebpage(HttpURLConnection connection) throws IOException, ParseException {
		Path testHTMLPath = Paths.get("\\Users\\admin\\functionalFitness\\fITnessapp\\src\\main\\webapp\\apitest.html");
		File testHTMLFile = testHTMLPath.toFile();
		// read response into buffer
		BufferedReader jsonReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonReader);

		// get an array from the JSON object
		JSONArray results = (JSONArray) jsonObject.get("results");

		Iterator<?> i = results.iterator();

		// take each value from the json array separately
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			// System.out.println("NAME: "+ innerObj.get("name")+"\n
			// Description" + innerObj.get("description")+"\n");
			try (PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter(testHTMLFile, true))))) {
				out.println(innerObj.get("name") + "\n" + innerObj.get("description") + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


}