import java.util.HashMap;
import java.util.Locale;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Contains information about a room:
 * <ul> 1) the name of the room
 * <br> 2) the id of the temperature sensor device in the respective room
 * <br> 3) the surface of the room
 * <br> 4) a hashmap : Integer -- TreeSet(Double) called temperature_time_series,
 * where temperature_time_series(k) = an ascending sorted list which contains all the temperatures
 * observed from [ ref - k*3600, ref - (k+1)*3600 ), where k is an integer in [0, 24)
 * and ref = the reference timestamp
 * <br> 5) a hashmap : Integer -- TreeSet(Double) called humidity_time_series,
 * where humidity_time_series(k) = a descending sorted list which contains all the humidity values
 * observed from [ ref - k*3600, ref - (k+1)*3600 )
 * </ul>
 * @author Bogdan-Andrei Buga<br> Group 322CB 
 * <br>Automatic Control and Computer Science
 * <br>Polytechnic University of Bucharest
 */
public class Room {
	private String name;
	private String device_id;
	private int surface;
	
	HashMap<Integer, TreeSet<Double>> temperature_time_series;
	HashMap<Integer, TreeSet<Double>> humidity_time_series;
	
	/**
	 * Returns the value of the <i>name</i> variable.
	 * @return the name of the room
	 */
	public String getName() {
		return this.name;
	}	
	/**
	 * Returns the value of the <i>device_id</i> variable.
	 * @return the id of the temeperature sensor device
	 */
	public String getDeviceID() {
		return this.device_id;
	}
	/**
	 * Returns the value of the <i>surface</i> variable.
	 * @return the surface of the room
	 */
	public int getSurface() {
		return this.surface;
	}
	/**
	 * Sets the <i>name</i> variable.
	 * @param name the new value of the aforementioned variable
	 */
	public void SetName(String name) {
		this.name = name;
	}
	/**
	 * Sets the <i>device_id</i> variable.
	 * @param device_id the new value of the aforementioned variable
	 */
	public void SetDeviceID(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * Sets the <i>surface</i> variable.
	 * @param surface the new value of the aforementioned variable
	 */
	public void SetSurface(int surface) {
		this.surface = surface;
	}	
	
	/** 	
	 * Builds a new room with all the necesary values in the parameters of the function.
	 * @param name the name of the room
	 * @param device_id the id of the temeperature sensor device
	 * @param surface the surface of the room
	 */
	public Room(String name, String device_id, int surface) {
		this.SetName(name);
		this.SetDeviceID(device_id);
		this.SetSurface(surface);
		
		this.temperature_time_series = new HashMap<Integer, TreeSet<Double>>();
		this.humidity_time_series = new HashMap<Integer, TreeSet<Double>>();
	}
	
	/**
	 * Calculates how many hours are between a specified time and a specified reference.
	 * @param time the necesary timestamp
	 * @param ref the referance timestamp
	 * @return how many hours have passed from the first parameter to the second
	 */
	public int getHour(Long time, Long ref) {
		return (int) ((ref - time) / 3600);
	}
	
	/**
	 * Adds a new temperature at the temperature sensor device at a specific timestamp.
	 * from a reference timestamp.
	 * @param ref the reference timestamp
	 * @param timestamp the desired timestamp
	 * @param temperature the desired temperature
	 */
	public void addObservedTemperature(long ref, long timestamp, Double temperature) {
		if((ref <= timestamp) || (ref - timestamp >= 86400)) 
			return;
			
		int index = this.getHour(timestamp, ref);
		if(temperature_time_series.get(index) == null)
			temperature_time_series.put(index, new TreeSet<Double>());
		temperature_time_series.get(index).add(temperature);
	}
	
	/**
	 * Adds a new humidity value at the temperature sensor device at a specific timestamp.
	 * @param ref the reference timestamp
	 * @param timestamp the desired timestamp
	 * @param humidity the desired humidity value
	 */
	public void addObservedHumidity(long ref, long timestamp, Double humidity) {
		if((ref <= timestamp) || (ref - timestamp >= 86400)) 
			return;
	
		int index = this.getHour(timestamp, ref);
		if(humidity_time_series.get(index) == null)
			humidity_time_series.put(index, new TreeSet<Double>(Comparator.reverseOrder()));
		humidity_time_series.get(index).add(humidity);
	}
	
	/**
	 * Generates a list of all the observed temperatures in a specified time interval.
	 * @param ref the reference timestamp
	 * @param from the first timestamp
	 * @param to the last timestamp
	 * @return a message which contains the name of the room and all the temperatures in
	 * the [from, to] interval
	 */
	public String listSensor(Long ref, Long from, Long to) {
		if(from > to)
			return null; // just in case
		
		String result = this.getName();
		int end_hour = this.getHour(from, ref);
		int start_hour = this.getHour(to, ref);
		
		for(int i = start_hour; i < end_hour; ++i)
			if(this.temperature_time_series.get(i) != null)
				for(Double j : this.temperature_time_series.get(i))
					result += " " + String.format(Locale.US, "%.2f", j);
					
		return result;
	}
}