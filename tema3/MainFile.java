import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFile {
	public static void printRegisteredTeams(ArrayList<Team> database, PrintWriter print_writer) {
		int idx = 0;
		while(idx < database.size() - 1)
			print_writer.println(database.get(idx++).toString());

		// no newline after the last team
		print_writer.print(database.get(idx).toString()); 
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File f1 = new File(args[1]);
		Scanner input1 = new Scanner(f1); // first scanner
		File g = new File(args[3]); // output file
		PrintWriter output = new PrintWriter(g);
		
		int n; // the number of players from a team
		String buffer;
		String[] team_desc, player_desc; // team description and player description
		TeamFactory team_factory = TeamFactory.getInstance(); // Singleton
		ArrayList<Team> team_database = new ArrayList<Team>();
		Team t;
		
		while(input1.hasNextLine()) {
			buffer = input1.nextLine();
			team_desc = buffer.split(", ");
			n = Integer.parseInt(team_desc[3]); // 'atoi' equivalent in Java
			t = team_factory.createTeam(team_desc[0], team_desc[1], team_desc[2], n); // Factory
			
			for(int i = 1; i <= n; ++i) {
				buffer = input1.nextLine();
				player_desc = buffer.split(", ");
				
				// add the resulted player in the team list
				t.getPlayers().add(new Player(player_desc[0], Integer.parseInt(player_desc[1])));
			}
			// add the resulted team in the database
			team_database.add(t);
		}
		input1.close();

		// register
		if(args[0].equals("inscriere"))
			printRegisteredTeams(team_database, output);
		
		// competition
		else if(args[0].equals("competitie")) {
			File f2 = new File(args[2]);
			Scanner input2 = new Scanner(f2); // second scanner
			buffer = input2.nextLine();
			
			String[] comp_desc = buffer.split(", "); // competition description
			String type = comp_desc[0], gender = comp_desc[1];
			Competition competition = new Competition(type, gender);
			
			while(input2.hasNextLine()) {
				String team_name = input2.nextLine();
				for(Team t_aux : team_database) {
					if(!t_aux.getName().equals(team_name))
						continue;
					competition.register(t_aux); // registration with Observer
					break; // once the team is found, we stop iterating through the database
				}
			}
			input2.close();
			
			// play all possible matches
			competition.playAllMatches();			
			
			// print the first three ranks of the competition
			competition.printFirstThreeTeams(output);
			
			// print all teams in the order they have been added in the competition and their ranks
			competition.printAllTeamsWithRank(output);
		}		
		output.close();
	}
}