import java.util.ArrayList;
import java.util.Collections;

/**
 * The Team Class contains the necesary data of a team: the type and gender of competition 
 * where it is eligible to compete, its name, its players, its number of points, its number 
 * of players and its rank in its competition (if necesary).
 * @author Bogdan - Andrei Buga, 322CB
 *
 */
public class Team implements Observer {
	private String name;
	private String gender;
	private int no_players;
	private int points;
	private int rank;
	private ArrayList<Player> players;
	
	// team getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNumberOfPlayers() {
		return no_players;
	}
	public void setNumberOfPlayers(int no_players) {
		this.no_players = no_players;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * Builds a new team with team with its type, name, gender and number of players
	 * given as parameters; default rank and number of points are both 0.
	 * @param team_name the name of the team;
	 * @param gender the gender of its players;
	 * @param no_players the number of players.
	 */
	public Team(String team_name, String gender, int no_players) {
		this.setName(team_name);
		this.setGender(gender);
		this.setNumberOfPlayers(no_players);
		this.setPoints(0);
		this.setRank(0);
		this.setPlayers(new ArrayList<Player>());
	}
	
	/**
	 * Is the function we need for the first task of this project.
	 * @return a string which contains all the information of the instance team.
	 */
	public String toString() {
		String result = "{teamName: " + this.getName();
		result += ", gender: " + this.getGender();
		result += ", numberOfPlayers: " + this.getNumberOfPlayers();
		result += ", players: [";
		
		result += this.getPlayers().get(0).toString();
		for(int i = 1; i < this.getPlayers().size(); ++i)
			result += ", " + this.getPlayers().get(i).toString();
		result += "]}";
		return result;
	}

	/**
	 * Is the function we need for the second task of this project.
	 * @return a string with the name and the rank of the instance.
	 */
	public String toString_Competition_() {
		return "Echipa " + this.getName() + " a ocupat locul " + this.getRank();
	}
	
	/**
	 * Is a function used in a Visitor design pattern.
	 * @param visitor the score visitor used to access the score of the instance team.
	 * @return the score of the instance team.
	 */
	/*
	
	public double accept(ScoreVisitor visitor) {
		if(this instanceof FootballTeam)
			return visitor.getScoreOf((FootballTeam) this); // "getScoreOf" is equivalent to "visit"
		else if(this instanceof BasketballTeam)
			return visitor.getScoreOf((BasketballTeam) this); // "getScoreOf" is equivalent to "visit"
		else if(this instanceof HandballTeam)
			return visitor.getScoreOf((HandballTeam) this); // "getScoreOf" is equivalent to "visit"
		return 0;
	}
	*/
	
	/**
	 * Updates the rank of the instance team after a match has been finished;
	 * this update also depends on the points 
	 * of all the other teams in the respective competition.
	 * @param teams the list with all the teams in the competition.
	 */
	public void update(ArrayList<Team> teams) {
		ArrayList<Team> aux = new ArrayList<Team>(teams); // a copy of the original team list
		// this copy will be sorted by the points of all teams in descending order
		Collections.sort(aux, (new PointComparator()).reversed());
		
		for(Team t : aux)
			if(this.equals(t)) {
				this.setRank(aux.indexOf(t) + 1); // update the rank in the competition
				break;
			}
	}
}