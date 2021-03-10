import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author Bogdan - Andrei Buga, 322CB
 *
 */
public class ScoreVisitor implements Visitor {
	
	/**
	 * Returns the score of the parameter team.
	 * @param t the team whose score we want to return.
	 * @return the score of the team.
	 */
	
	/** Returns the score of a football team with the formula: <br>
	*	Score = Sum[score of all players] +
	*	<ul>
	*	<li>the highest score in the team (male football).</li>
	*	<li>the lowest score in the team (female football);</li>
	*	</ul>
	*/
	public double getScoreOf(FootballTeam ft) {
		double score = 0;
		ArrayList<Player> aux = new ArrayList<Player>(ft.getPlayers());
		Collections.sort(aux);
		
		for(Player p : aux)
			score += p.getScore();
		if(ft.getGender().equals("masculin"))
			score += aux.get(aux.size() - 1).getScore();
		else if(ft.getGender().equals("feminin"))
			score += aux.get(0).getScore();
		
		aux.clear();
		return score;
	}

	/** Returns the score of a basketball team with the formula: <br>
	*	Score = Sum[score of all players] / number of players in the team.
	*/
	public double getScoreOf(BasketballTeam bt) {
		double score = 0;
		for(Player p : bt.getPlayers())
			score += p.getScore();
		if(score != 0)
			score /= bt.getPlayers().size();
		return score;
	}
	
	/** Returns the score of a football team with the formula: <br>
	*	Score =
	*	<ul>
	*	<li>Sum[score of all players] (male handball).</li>
	*	<li>Product[score of all players] (female handball);</li>
	*	</ul>
	*/
	public double getScoreOf(HandballTeam ht) {
		double score = 0;
		if(ht.getGender().equals("masculin"))
			for(Player p : ht.getPlayers())
				score += p.getScore();
		else if(ht.getGender().equals("feminin")) {
			score = 1;
			for(Player p : ht.getPlayers())
				score *= p.getScore();
		}
		return score;
	}
}
