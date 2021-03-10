import java.util.Comparator;
/**
 * The PointComparator Class is a special comparator, 
 * which compares two given teams by their number of points.
 * We need this comparator when we need to find out 
 * the ranks of each team after a match.
 * @author Bogdan - Andrei Buga, 322CB
 */
public class PointComparator implements Comparator<Team>{
	/**
	 * Returns the difference of points between the two parameter teams.
	 */
	public int compare(Team t1, Team t2) {
		Integer p1 = t1.getPoints();
		Integer p2 = t2.getPoints();
		return p1.compareTo(p2);
	}
}
