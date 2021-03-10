/**
 * The BasketballTeam Class represents the second of the three possible types of team.
 * @author Bogdan - Andrei Buga, 322CB
 */
public class BasketballTeam extends Team implements Visitable {
	/**
	 * Builds a basketball team with given name, gender and number of players 
	 * (which is, usually, 5).
	 * @param team_name the name of the team;
	 * @param gender the gender of the players;
	 * @param no_players the numbers of players in the team.
	 */
	public BasketballTeam(String team_name, String gender, int no_players) {
		super(team_name, gender, no_players);
	}
	
	@Override
	public double accept(Visitor visitor) {
		return visitor.getScoreOf(this);
	}
}
