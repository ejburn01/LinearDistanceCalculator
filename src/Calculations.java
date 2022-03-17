
public class Calculations {
	
	
	public static double getDistance(double lat1, double long1, double lat2, double long2) {
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		long1 = Math.toRadians(long1);
		long2 = Math.toRadians(long2);
		
		double calc1 = Math.pow(   (Math.sin((lat2 - lat1)/2)), 2.0);
		double calc2 = Math.cos(lat1) * 
				Math.cos(lat2) * Math.pow(   (Math.sin((long2 - long1)/2)) , 2.0)    ;
		double calc3 = Math.sqrt(calc1 + calc2);
		double distance = 2 * (3958.8) * Math.asin(calc3);
		return distance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDistance(43.0731, -89.4012, 18.5204, 73.8567));

	}

}
