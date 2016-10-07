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

		// Making new file to write to.
		Path testHTMLPath = Paths.get("\\Users\\admin\\functionalFitness\\fITnessapp\\src\\main\\webapp\\apitest.html");
		File testHTMLFile = testHTMLPath.toFile();

		// reading API response into buffer
		BufferedReader jsonReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		// parsing API response into JSON object and putting it into array
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonReader);
		JSONArray results = (JSONArray) jsonObject.get("results");

		// looking through array for the specified fields and writing it to file
		Iterator<?> i = results.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			try (PrintWriter out = new PrintWriter(new BufferedWriter((new FileWriter(testHTMLFile, true))))) {
				out.println(innerObj.get("name") + "\n" + innerObj.get("description") + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
