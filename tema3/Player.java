/**
 * The Player Class contains the necesary data of a player: his/her name and score.
 * <br>All players are comparable by their score.
 * @author Bogdan - Andrei Buga, 322CB
 *
 */
public class Player implements Comparable<Object>{
	private String name;
	private int score;
	
	// player setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Builds a new player with its values given as parameters.
	 * @param name the name of the player;
	 * @param score the score of the player.
	 */
	public Player(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	

	/**
	 * Returns a string with the information about a player 
	 * arranged especially for the first task.
	 */
	public String toString() {
		return "{name: " + this.getName() + ", score: " + this.getScore() + "}";
	}
	
	/**
	 * Represents the score comparator; return values:
	 * <ul> 
	 * <li> 1, if the instance has a greater score than the parameter;</li>
	 * <li> 0, if the instance has the same score as the parameter;</li>
	 * <li>-1, if the instance has a lower score than the parameter.</li>
	 * </ul>
	 */
	@Override
	public int compareTo(Object o) {
		int diff = this.getScore() - ((Player) o).getScore();
		if(diff != 0)
			diff /= Math.abs(diff);
		return diff;
	}
}