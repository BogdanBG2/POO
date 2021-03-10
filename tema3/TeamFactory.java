/**
 * The TeamFactory Class is a special class, 
 * which is used not only within a Factory design pattern,
 * but also within a Singleton one.
 * Its main purpose is to create a team of a specific input type.
 * @author Bogdan - Andrei Buga, 322CB
 *
 */
public class TeamFactory {
	private static TeamFactory instance;
	public static TeamFactory getInstance() { // Singleton implementation
		if(instance == null)
			instance = new TeamFactory();
		return instance;
	}
	/**
	 * Creates a team with a given type and characteristics. 
	 * @param team_type the type of the team;
	 * @param team_name the name of the team;
	 * @param gender the gender of the players;
	 * @param no_players 
	 * @return a new football / basketball / handball team with 
	 */
	public Team createTeam(String team_type, String team_name, String gender, int no_players) {
		Team result = null;
		if(team_type.equals("football"))
			result = new FootballTeam(team_name, gender, no_players);
		else if(team_type.equals("basketball"))
			result = new BasketballTeam(team_name, gender, no_players);
		else if(team_type.equals("handball"))
			result = new HandballTeam(team_name, gender, no_players);
		
		return result;
	}
}