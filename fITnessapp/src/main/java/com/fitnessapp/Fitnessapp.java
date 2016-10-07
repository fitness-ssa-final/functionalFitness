package com.fitnessapp;

import java.util.Scanner;

import com.api.ConnectToWgerAPI;

public class Fitnessapp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userInput = null;

		// getting user input and changing it to the correct id for the API,
		// then calling the api method with correct user input

		System.out.println(
				"Please provide the equipment that you currently have access to with a 1 for yes or a 2 for no");

		System.out.println("Do you have access to a barbell?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "1";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a bench?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "8";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a dumbbells?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "3";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a gym mat?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "4";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a incline bench?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "9";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a kettlebells?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "10";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a pull-up bar?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "6";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to a swiss ball?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "5";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Do you have access to an ez-bar?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "2";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		System.out.println("Would you also like to body do weight exercises?");
		userInput = sc.nextLine();
		if (userInput.equals("1")) {
			userInput = "7";
			ConnectToWgerAPI.connectingToWgerAPI(userInput);
		}

		sc.close();
	}

}
