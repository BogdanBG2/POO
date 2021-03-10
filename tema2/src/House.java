import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Contains information about a house, such as:
 * <ul> 1) the rooms of the house
 * <br> 2) the global temperature
 * <br> 3) the global humidity (when it is the case)
 * </ul>
 * @author Bogdan-Andrei Buga<br> Group 322CB 
 * <br>Automatic Control and Computer Science
 * <br>Polytechnic University of Bucharest
 */
public class House {
	ArrayList<Room> rooms;
	private double global_temperature;
	private double global_humidity;
	
	/**
	 * Returns the value of the <i>global_temperature</i> variable.
	 * @return the desired global temperature of the house
	 */
	public double getGlobalTemperature() {
		return this.global_temperature;
	}
	
	/**
	 * Returns the value of the <i>global_humidity</i> variable.
	 * @return the desired global humidity value of the house
	 */
	public double getGlobalHumidity() {
		return this.global_humidity;
	}
	/**
	 * Sets the <i>global_temperature</i> variable.
	 * @param g_tmp the new value of the aforementioned variable
	 */
	public void setGlobalTemperature(double g_tmp) {
		this.global_temperature = g_tmp;
	}
	/**
	 * Sets the <i>global_humidity</i> variable.
	 * @param g_hmd the new value of the aforementioned variable
	 */
	public void setGlobalHumidity(double g_hmd) {
		this.global_humidity = g_hmd;
	}
	
	/**
	 * Builds a new house with all the necesary values in the parameters of the function.
	 * @param g_tmp the desired global temperature
	 * @param g_hmd the desired global humidity value
	 */
	public House(double g_tmp, double g_hmd) {
		this.rooms = new ArrayList<Room>();
		this.setGlobalTemperature(g_tmp);
		this.setGlobalHumidity(g_hmd);
	}
	
	/**
	 * Builds a new house where the humidity is neglected.
	 * @param g_tmp the desired global temperature
	 */
	public House(double g_tmp) {
		this(g_tmp, 0);
	}
	
	/**
	 * Adds a new room in the house.
	 * @param r the room to be added
	 */
	public void addRoom(Room r) {
		this.rooms.add(r);
	}

	/**
	 * Returns a message which indicates if the temperature sensor devices must be activated
	 * in order to reach the desired global temperature.
	 * @param ref_timestamp the reference timestamp
	 * @param bonus a boolean value which indicates if the humidity must be neglected or not 
	 * (false = neglected, true = not neglected)
	 * @return "YES, if the weighted average of the temperature and surface 
	 * is lower than the global temperature <br>
	 * "NO", otherwise
	 */
	public String triggerHeat(long ref_timestamp, boolean bonus) {
		double t_numerator = 0, h_numerator = 0, nominator = 0;
		
		TreeSet<Double> last_temps = null;
		TreeSet<Double> last_humids = null;
		for(Room r : rooms) {
			for(int j = 0; j < 24; ++j)  // j = hour from the reference
				if((r.temperature_time_series).get(j) != null) {
					last_temps = (r.temperature_time_series).get(j);
					break;
				}
			if(!last_temps.isEmpty()) {
				t_numerator += r.getSurface() * last_temps.first();
				nominator += r.getSurface();
			}
			
			if(bonus) { 
				for(int j = 0; j < 24; ++j)
					if((r.humidity_time_series).get(j) != null) {
						last_humids = (r.humidity_time_series).get(j);
						break;
				}				
			if(!last_humids.isEmpty())
				h_numerator += r.getSurface() * last_humids.first();
			}
		}
		
		double h_average = h_numerator / nominator; // if !bonus, h_average = 0 / total_surface = 0
		// first, we check the humidity condition, then, the temperature condition
		if(bonus && h_average > this.getGlobalHumidity()) 
			return "NO"; // if the average humidity is greater than the global one,
		// the temperature average is neglected

		double t_average = t_numerator / nominator;
		if(t_average > this.getGlobalTemperature())
			return "NO";

		return "YES";
	}
}