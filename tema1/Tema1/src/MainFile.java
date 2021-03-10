import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MainFile {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("queue.in"); // input file
		File g = new File("queue.out"); // output file
		String id, name, tt; // id, name & ticket type
		int n, age; // # of passengers & age
		boolean pe, sn; // (prioritary embarking?), (special needs?)
		
		try {
			Scanner input = new Scanner(f);
			n = input.nextInt();

			NecesaryPriorityQueue queue = new NecesaryPriorityQueue(n, g);
			
			// Step 1: generating the flight database
			HashMap<String, Passenger> flightDatabase = new HashMap<String, Passenger>();
			for(int i = 0; i < n; ++i) {			

				// Proccesing the data from input file to the flight database
				id = input.next();
				name = input.next();
				age = input.nextInt();
				tt = input.next();
				pe = input.nextBoolean();
				sn = input.nextBoolean();

				switch(id.charAt(0)) {
					case 's': // single
						flightDatabase.put(id, new Single(id, name, age, tt, pe, sn));
						break;
					case 'g': // group
						if(!flightDatabase.containsKey(id))
							flightDatabase.put(id, new Group(id));
						((Group) flightDatabase.get(id)).addGroupMember(name, age, tt, pe, sn);
						break;
					case 'f': // family
						if(!flightDatabase.containsKey(id))
							flightDatabase.put(id, new Family(id));
						((Family) flightDatabase.get(id)).addFamilyMember(name, age, tt, pe, sn);
						break;
				}
			}
			// Setting all the necesary priorities
			for(String i : flightDatabase.keySet())
				flightDatabase.get(i).setPriority();

			// Reading and executing all the commands from the input file
			String command = input.nextLine();
			while(input.hasNext()) {
				command = input.nextLine();

				if(command.contains("insert")) {
					id = command.substring(7); // "insert <id>" -> "<id>"
					if(!flightDatabase.containsKey(id))
						System.out.println("Error: id not found"); // just in case ¯\_(ツ)_/¯
					else 
						queue.insert(flightDatabase.get(id), flightDatabase.get(id).getPriority());
				}

				else if(command.equals("embark"))
					queue.embark();
				
				else if(command.equals("list")) {
					queue.list();
					if(input.hasNextLine()) // add a new line only if this is NOT the last command
						queue.writer.println();
				}
				else if(command.contains("delete")) {
					id = command.substring(7); // "delete <id>" -> "<id>"
					if(!flightDatabase.containsKey(id))
						System.out.println("Error: id not found"); // just in case ¯\_(ツ)_/¯
					else
					queue.delete(flightDatabase.get(id));
				}
			}

			input.close();
			queue.closeWriter();

		} catch (IOException ex) {
			System.out.printf("Error: %s\n", ex);
		}
	}
}
