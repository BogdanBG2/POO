/**
 * The HandballTeam Class represents the third of the three possible types of team.
 * @author Bogdan - Andrei Buga, 322CB
 */
public class HandballTeam extends Team implements Visitable {
	/**
	 * Builds a handball team with given name, gender and number of players 
	 * (which is, usually, 7).
	 * @param team_name the name of the team;
	 * @param gender the gender of the players;
	 * @param no_players the numbers of players in the team.
	 */
	public HandballTeam(String team_name, String gender, int no_players) {
		super(team_name, gender, no_players);
	}
	
	@Override
	public double accept(Visitor visitor) {
		return visitor.getScoreOf(this);
	}
}
