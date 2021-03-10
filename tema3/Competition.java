import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * The Competition Class is used in and Observer design pattern as a Subject,
 * and the registered teams play the role of the Observers. The primary information
 * consists of the type and gender of the competition, a list with all the registered teams,
 * the number of teams and a ranking function, which simplifies
 * @author Bogdan - Andrei Buga, 322CB
 */
public class Competition implements Subject {
	private String type;
	private String gender;
	private ArrayList<Team> teams;
	private int no_teams = 0;
	
	// competition setters and getters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}	
	public int getNumberOfTeams() {
		return no_teams;
	}
	public void setNumberOfTeams(int no_teams) {
		this.no_teams = no_teams;
	}

	/**
	 * Returns a ranking system where 
	 * the rank and the name of each team 
	 * is remembered as a HashMap.
	 * @return a HashMap function with Integer keys from 1 to the number of teams
	 * and String values which represent the names of the teams.
	 */
	public HashMap<Integer, String> ranking() {
		HashMap<Integer, String> ranking = new HashMap<Integer, String>();
		for(Team t : this.getTeams())
			ranking.put(t.getRank(), t.getName());
		return ranking; 
	}
	
	/**
	 * Builds a new competition with the type and gender specified as parameters;
	 * the default number of teams is 0.
	 * @param type the type of the competition;
	 * @param gender the gender of the players.
	 */
	public Competition(String type, String gender) {
		this.setType(type);
		this.setGender(gender);
		this.teams = new ArrayList<Team>();
		this.setNumberOfTeams(0);
	}
	/**
	 * Registers (adds) a new team (Observer) in the competition
	 * only if it has the required type and gender.
	 * @param o the observer team to be added;
	 */
	public void register(Observer o) {
		Team t = (Team) o;
		String team_type = t.getClass().getName().toLowerCase(); // AbcdefgTeam -> abcdefgteam
		team_type = team_type.substring(0, team_type.length() - 4); // abcdefgteam -> abcdefg
		String team_gender = t.getGender();
		if(!team_type.equals(this.getType()) || !team_gender.equals(this.getGender()))
			return; // the team is not added
		this.getTeams().add(t);
		this.setNumberOfTeams(this.getNumberOfTeams() + 1); // the number of teams is incremented
	}

	/**
	 * Updates each team about all the changes after a match.
	 */
	public void notifyObservers() {
		for(Observer o : this.getTeams())
			o.update(this.getTeams());
	}
	
	/**
	 * Compares the scores of two teams whose index in the team list are given as parameters
	 * and, based on the score differnce, adds points to either jsut one team or both.
	 * Once the points have been added, if necesary, all teams will have their rank updated
	 * by calling the <i>notifyObservers()</i> method.
	 * @param i the index of the host team;
	 * @param j the index of the guest team.
	 */
	public void playMatch(int i, int j) {
		ScoreVisitor score = new ScoreVisitor(); // the score cannot be accessed without a Visitor
		Team home_team = this.getTeams().get(i);
		Team away_team = this.getTeams().get(j);
		
		
		double home_score = 0;
		double away_score = 0;

		if(this.getType().equals("football")) {
			home_score = ((FootballTeam) home_team).accept(score);
			away_score = ((FootballTeam) away_team).accept(score);
		}
		else if(this.getType().equals("basketball")) {
			home_score = ((BasketballTeam) home_team).accept(score);
			away_score = ((BasketballTeam) away_team).accept(score);
		}
		else if(this.getType().equals("handball")) {
			home_score = ((HandballTeam) home_team).accept(score);
			away_score = ((HandballTeam) away_team).accept(score);
		}
		
		// home win 
		if(home_score > away_score)
			home_team.setPoints(home_team.getPoints() + 3);
		// away win
		else if(home_score < away_score)
			away_team.setPoints(away_team.getPoints() + 3);
		// draw
		else if(home_score == away_score) {
			home_team.setPoints(home_team.getPoints() + 1);
			away_team.setPoints(away_team.getPoints() + 1);
		}
		this.notifyObservers(); // all teams will be notified by the result of this match
	}

	/**
	 * Sets the points of all teams after playing all the possible matches 
	 * no more than once.
	 */
	public void playAllMatches() {
		for(int home = 0; home < this.getNumberOfTeams() - 1; ++home)
			for(int away = home + 1; away < this.getNumberOfTeams(); ++away)
				this.playMatch(home, away);
	}
	
	/**
	 * Prints the names of first three ranked teams with a given PrintWriter.
	 * @param print_writer the destination file to write the result mentioned in the description.
	 */
	public void printFirstThreeTeams(PrintWriter print_writer) {
		for(int idx = 1; idx <= 3; ++idx)
			print_writer.println(this.ranking().get(idx));
	}
	
	/**
	 * Prints the names of all teams by the order they have been registered in the competition,
	 * along with their ranks at the end of the competition.
	 * @param print_writer the destination file to write the result mentioned in the description.
	 */
	public void printAllTeamsWithRank(PrintWriter print_writer) {
		HashMap<Integer, String> final_ranking = this.ranking();
		for(int idx = 0; idx < this.getNumberOfTeams(); ++idx) {
			int key = this.getTeams().get(idx).getRank();
			print_writer.print("Echipa " + final_ranking.get(key) + " a ocupat locul " + key);
			if(idx < this.getNumberOfTeams() - 1)
				print_writer.println(); // add new line if we are not at the last iteration
		}
	}
}