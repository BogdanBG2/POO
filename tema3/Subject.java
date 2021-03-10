/**
 * The Subject Class is used in an Observer design pattern 
 * between the Team and Competition classes.
 * @author Bogdan - Andrei Buga, 322CB
 */
public interface Subject {
	/**
	 * Registers the Observer parameter in the Subject instance.
	 * @param o - the obsever to be registered.
	 */
	public void register(Observer o);
	
	/**
	 * Notifies the registered observers about every modification
	 * of the variables from all observers.
	 */
	public void notifyObservers();
}
