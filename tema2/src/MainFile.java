import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainFile {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("therm.in"); // input file
		File g = new File("therm.out"); // output file
		
		Scanner in = new Scanner(f); 
		PrintWriter out = new PrintWriter(g);
		
		String buffer = in.nextLine();
		String[] parameters = buffer.split(" ");
		boolean bonus = (parameters.length == 4);
		
		int n = Integer.parseInt(parameters[0]); // number of sensors
		double global_temp = Double.parseDouble(parameters[1]); // the desired temperature
		long ref_timestamp = (bonus) ? // the reference timestamp
				Long.parseLong(parameters[3]) : Long.parseLong(parameters[2]);
		double global_humidity = (bonus) ? // the desired humidity
				Double.parseDouble(parameters[2]) : 0; // "default" humidity = 0
		House home = (bonus) ?
				new House (global_temp, global_humidity) : new House(global_temp);
				
		
		for(int i = 1; i <= n; ++i) // adding the rooms in the house
			home.addRoom(new Room(in.next(), in.next(), in.nextInt()));
			//						NAME	 DEVICE ID	  SURFACE
				
		String command;
		while(in.hasNext()) {
			command = in.next();
/*-------*/ if(command.compareTo("OBSERVE") == 0) { // OBSERVE -------------------------------
				String id = in.next();
				Long timestamp = in.nextLong();
				buffer = in.next();
				Double temperature = Double.parseDouble(buffer);
				
				for(Room r : home.rooms)
					if(r.getDeviceID().compareTo(id) == 0) {
						r.addObservedTemperature(ref_timestamp, timestamp, temperature);
						break; // in order to reduce the number of iterations
					}
			}
/*-------*/ else if(command.compareTo("OBSERVEH") == 0) { // OBSERVEH ------------------------
				String id = in.next();
				Long timestamp = in.nextLong();
				buffer = in.next();
				Double humidity = Double.parseDouble(buffer);
				
				for(Room r : home.rooms)
					if(r.getDeviceID().compareTo(id) == 0) {
						r.addObservedHumidity(ref_timestamp, timestamp, humidity);
						break; // in order to reduce the number of iterations
					}
			}
/*-------*/ else if(command.compareTo("TRIGGER") == 0) { // TRIGGER HEAT ---------------------
				buffer = in.next(); // HEAT
				out.println(home.triggerHeat(ref_timestamp, bonus));
			}
/*-------*/ else if(command.compareTo("TEMPERATURE") == 0) { // TEMPERATURE ------------------
				buffer = in.next();
				Double new_temperature = Double.parseDouble(buffer);
				home.setGlobalTemperature(new_temperature);
			}
/*-------*/ else if(command.compareTo("LIST") == 0) { // LIST --------------------------------
				String name = in.next();
				Long start = in.nextLong();
				Long end = in.nextLong();

				for(Room r : home.rooms)
					if(name.compareTo(r.getName()) == 0) {
						out.print(r.listSensor(ref_timestamp, start, end));
						if(in.hasNextLine())
							out.println();
						break; // in order to reduce the number of iterations
					}
			}
		}
		in.close();
		out.close();
	}
}