/**
 * This is our main <i>Passenger / Pasager</i> class, the one which
 * will be used to implement the heap / priority queue.
 * @author Bogdan-Andrei Buga<br> Group 322CB 
 * <br>Automatic Control and Computer Science
 * <br>Polytechnic University of Bucharest
 */
public abstract class Passenger implements Comparable<Object> {
	protected String id;
	protected int priority = 0;
	
	// Passenger constructors
	/**
	 * Builds a new passenger with the id given as parameter.
	 * @param id
	 */
	public Passenger(String id) {
		this.id = id;
	}
	/**
	 * Returns the value of the <i>id</i> variable.
	 * @return The id of the passenger.
	 */
	public String getID() {
		return id;
	}
	/**
	 * Sets the id of the passenger with a given value.
	 * @param id the new id of the passenger
	 */
	public void setID(String id) {
		this.id = id;
	}
	/**
	 * Returns the value of the <i>priority</i> variable.
	 * @return The priority of the passenger.
	 */
	public abstract int getPriority();
	/**
	 * This function, despite being named as a setter,
	 * calculates the priority of the passsenger.
	 * Since the formula is diffrent for each passenger entity,
	 * we will implement the formula for each of these entities (single, group and family) seperately.
	 */
	public abstract void setPriority();
	
	/**
	 * Compares the priority of the instance with the priority of the parameter.
	 * @return -1, if the priority of the instance is lesser than the priority of the parameter;
	 * <br> 0, if the two priorities are equal;
	 * <br> 1, if the priority of the instance is greater than the priority of the parameter.
	 */
	public int compareTo(Object o) {
		int diff = (int)(this.getPriority() - ((Passenger) o).getPriority());
		if(diff != 0)
			diff /= Math.abs(diff);
		return diff;
	}
}
