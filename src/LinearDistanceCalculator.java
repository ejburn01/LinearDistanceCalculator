import java.util.Scanner;

public class LinearDistanceCalculator {
	
	static double[] firstCoords = {0,0};
	static double[] secondCoords = {0,0};
	static boolean runProgram = true;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		CityList.fillCityList(40000);
		System.out.println("Welcome to Linear Distance Calculator!\nThis application calculates the"
				+ " linear distance between two cities based off of their coordinates.");
		while(runProgram) {
		getUserInput(scnr);
		runProgram = runAgain(scnr);
		}
		scnr.close();

	}
	
	public static void getUserInput(Scanner scnr) {
		boolean inValidInput = true;
		System.out.println("Please enter the first city");
		while (inValidInput) {
			String userInput1 = scnr.nextLine();
			firstCoords = getCityCoords(userInput1);
			if (firstCoords[0] != 0 && firstCoords[1] != 0) {
				inValidInput = false;
			}
		}
		System.out.println("Please enter the second city");
		inValidInput = true;
		while (inValidInput) {
			String userInput1 = scnr.nextLine();
			secondCoords = getCityCoords(userInput1);
			if (secondCoords[0] != 0 && secondCoords[1] != 0) {
				inValidInput = false;
			}
		}
		System.out.println("The linear distance between these two cities is " + 
		Calculations.getDistance(firstCoords[0],firstCoords[1],secondCoords[0],secondCoords[1]) 
		+ " miles");
	}
	
	public static boolean runAgain(Scanner scnr) {
		System.out.println("Would you like to run this application again? Y/N");
		boolean run = false;
		do {
			run = true;
		String userInput1 = scnr.nextLine();
		if (userInput1.equalsIgnoreCase("Y") || userInput1.equalsIgnoreCase("Yes")) {
			return true;
		}
		else if (userInput1.equalsIgnoreCase("N") || userInput1.equalsIgnoreCase("No")) {
			System.out.println("Goodbye!");
			return false;
		}
		else {
			System.out.println("Invalid input, please type \"y\" or \"n\"");
			run = true;
		}
		}while (run);
		return false;
	}
	
	public static double[] getCityCoords(String userInput) {
		for (int i = 0; i < CityList.cityList.size(); i++ ) {
			if (CityList.cityList.get(i).getName().equalsIgnoreCase(userInput)) {
				double[] coords = {CityList.cityList.get(i).getLatitude(), CityList.cityList.get(i).getLongitude()};
				return coords;
			}
		}
		System.out.println("City not found within the database, please try searching for another city");
		double[] error = {0,0};
		return error;
	}

}
