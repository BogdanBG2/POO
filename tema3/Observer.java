import java.util.ArrayList;

/**
 * The Observer Class is used in an Observer design pattern
 * between the Team and Competition Classes.
 * @author Bogdan - Andrei Buga, 322CB
 *
 */
public interface Observer {
	/**
	 * Updates an instance based on data 
	 * of a list of teams given as parameter.
	 * @param teams the list of registered teams.
	 */
	public void update(ArrayList<Team> teams);
}
