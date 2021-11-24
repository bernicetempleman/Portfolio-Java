
public class WeatherMachine {
	Thermometer t;
	String city;
	
	public WeatherMachine(String city) {
		this.city = city;
		
	}
	
	public WeatherMachine() {
		
		this("Youngstown");
		 t = new Thermometer();
		 
		 } 

	
	
	private double[] getPastTemperatures() {
		
		double[] result = new double[24];

		 for(int i = 0; i < result.length; i++) {
		 result[i] = t.getTemperature();
		 }

		 return result; 
		
	}

	public void getWeatherReprt() {
		// TODO Auto-generated method stub
		System.out.println("Your Current location: " + city); 
		System.out.println("Your last 24 hours:");
		 double[] temps = getPastTemperatures();

		 for(int i = 0; i < temps.length; i++) {
		 System.out.println(i + ":00 " + temps[i] + " degrees");
		 } 
	}

}
