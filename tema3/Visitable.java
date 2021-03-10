/**
 * The Visitable class is a component of the Visitor design pattern
 * used for the second task of this project.
 * @author Bogdan - Andrei Buga, 322CB
 *
 */
public interface Visitable {
	/**
	 * Returns the return value of the <i>getScoreOf</i> function
	 * called from the parameter instance.
	 * @param v the instance to be called.
	 * @return the score of the visitor instance.
	 */
	public double accept(Visitor v);
}
