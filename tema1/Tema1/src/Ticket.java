/**
 * Contains information about flight tickets:
 * <ul> 1) the ticket type
 * <br> 2) if a passenger has prioritary embarking with his/her ticket
 * <br> 3) if the respective passenger has special needs
 * </ul>
 * @author Bogdan-Andrei Buga<br> Group 322CB 
 * <br>Automatic Control and Computer Science
 * <br>Polytechnic University of Bucharest
 *
 */
public class Ticket {
	protected String ticket_type;
	protected boolean prioritary_embarking;
	protected boolean special_needs;
	
	// getters
	/**
	 * Returns the value of the <i>ticket_type</i> variable.
	 * @return The type of the ticket; can be:
	 * <br><ul> <b>e</b> - for economic
	 * <br> <b>p</b> - for premium
	 * <br> <b>b</b> - for business
	 */
	public String getTicketType() {
		return this.ticket_type;
	}
	/**
	 * Returns the value of the <i>prioritary_embarking</i> variable.
	 * @return <u>True</u>, if the passenger has prioritary embarking with his ticket;
	 * <br> <u>False</u>, otherwise.
	 */
	public boolean getPrioritaryEmbarking() {
		return this.prioritary_embarking;
	}
	/**
	 * Returns the value of the <i>special_needs</i> variable.
	 * @return <u>True</u>, if the passenger has special needs;
	 * <br> <u>False</u>, otherwise.
	 */
	public boolean getSpecialNeeds() {
		return this.special_needs;
	}
	
	// setters
	/**
	 * Sets the <i>ticket_type</i> variable.
	 * @param tt - the new value of the aforementioned variable
	 */
	public void setTicketType(String tt) {
		this.ticket_type = tt;
	}
	/**
	 * Sets the <i>prioritary_embarking</i> variable.
	 * @param pe - the new value of the aforementioned variable
	 */
	public void setPrioritaryEmbarking(boolean pe) {
		this.prioritary_embarking = pe;
	}
	/**
	 * Sets the <i>special_needs</i> variable.
	 * @param sn - the new value of the aforementioned variable
	 */
	public void setSpecialNeeds(boolean sn) {
		this.special_needs = sn;
	}
	
	// Ticket constructor
	/**
	 * Builds a new ticket with all the necesary values in the parameters of the function.
	 * @param tt - the ticket type
	 * @param pe - prioritary embarking
	 * @param sn - special needs
	 */
	public Ticket(String tt, boolean pe, boolean sn) {
		this.setTicketType(tt);
		this.setSpecialNeeds(sn);
		this.setPrioritaryEmbarking(pe);
	}
}
