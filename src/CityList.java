import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CityList {
	public static ArrayList<City> cityList = new ArrayList<City>();

	public static void fillCityList(int numCities) {
		String path = "C:\\Users\\ejbur\\Documents\\worldcities.csv";
		String line = "";
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			while ((line = br.readLine()) != null && i < numCities) {
				String[] values = line.split(",");
				int j = 0;
				for (j = 0; j < 4; j++) {
					if (values[j].charAt(0) == '"' ) {
					values[j] = values[j].substring(1, values[j].length() - 1);
					}
				}

				if (values[1].equals("city_ascii") || values[2].equals("lat") || values[3].equals("lng")) {
					continue;
				} else {
					//System.out.println(values[1] + ", " + values[2] + ", " + values[3]);
					
					i = i + 1;
					double latitude = Double.parseDouble(values[2]);
					double longitude = Double.parseDouble(values[3]);
					City newCity = new City(values[1], latitude, longitude);
					cityList.add(newCity);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}

}
