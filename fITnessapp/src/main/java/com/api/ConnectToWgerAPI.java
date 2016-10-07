package com.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.parser.ParseException;

public class ConnectToWgerAPI {

	// wger API Endpoint returning the specified exercise, in Json, in English,
	// with limit per page as 1000000 so results stay on 1 page
	protected static String endpoint = "https://wger.de/api/v2/exercise.json/?language=2&limit=1000000";

	// url encoding
	protected static String charset = "UTF-8";

	public static void connectingToWgerAPI(String userEquipment) {

		try {
			// Making wger API get request using user scanner input
			String queryString = String.format("equipment=%s", URLEncoder.encode(userEquipment, charset));
			URL wgerExercises = new URL(endpoint + "&" + queryString);
			HttpURLConnection connection = (HttpURLConnection) wgerExercises.openConnection();
			connection.setRequestMethod("GET");

			// If server response is anything but 'OK' throw error
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed:HTTP error code:" + connection.getResponseCode());
			} else {
				// calling method to get api data and write it to a webpage
				APIFileIO.writeToWebpage(connection);
			}

			// close connection to API
			connection.disconnect();

			// Catching exceptions
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
