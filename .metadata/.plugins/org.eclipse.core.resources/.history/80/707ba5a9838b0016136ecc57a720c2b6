package com.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConnectToWgerAPI {

	// wger API Endpoint returning json
	protected static String endpoint = "https://wger.de/api/v2/exercise.json/?language=2&limit=999";

	// url encoding
	protected static String charset = "UTF-8";
	static String exercisesFromAPI = null;

	public static void connectingToWgerAPI(String userEquipment) {

		try {
			Path testHTMLPath = Paths.get("\\Users\\admin\\functionalFitness\\fITnessapp\\apitest.txt");
			File testHTMLFile = testHTMLPath.toFile();
			String queryString = String.format("equipment=%s", URLEncoder.encode(userEquipment, charset));

			URL wgerExercises = new URL(endpoint + "&" + queryString);
			HttpURLConnection connection = (HttpURLConnection) wgerExercises.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed:HTTP error code:" + connection.getResponseCode());
			} else {
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

			// close connection to API
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
