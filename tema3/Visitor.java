/**
 * The Visitor Class is a key component in the Visitor design pattern
 * used for the second task of this project. <br>
 * Special note: the <i>getScoreOf</i> method is the equivalent of the <i>visit</i> method.
 * @author Bogdan - Andrei Buga, 322CB
 */
public interface Visitor {
	public double getScoreOf(FootballTeam ft);
	public double getScoreOf(BasketballTeam bt);
	public double getScoreOf(HandballTeam ht);
}
