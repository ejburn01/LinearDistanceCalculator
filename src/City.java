
public class City {
	private String name;
	private double latitude;
	private double longitude;
	
	public City(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
    public String getName() {
		return this.name;
	}
    
    public double getLatitude() {
		return this.latitude;
	}
    
    public double getLongitude() {
    	return this.longitude;
    }

}
