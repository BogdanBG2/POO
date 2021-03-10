/**
 * 	This class is an extension of the previously implemented <i>Passenger</i> class,
 *  which has only <b>1</b> member.
 *	@author Bogdan-Andrei Buga<br> Group 322CB 
 * 	<br>Automatic Control and Computer Science
 * 	<br>Polytechnic University of Bucharest
 */
public class Single extends Passenger {
	Member m;
	/**
	 * Builds a single passenger with the following parameters:
	 * @param id the id
	 * @param name the name
	 * @param age the age
	 * @param tt the ticket type
	 * @param pe if this member has prioritary embarking
	 * @param sn if this member has any special needs
	 */
	public Single(String id, String name, int age, String tt, boolean pe, boolean sn) {
		super(id);
		this.m = new Member(name, age, tt, pe, sn);
	} 
	/**
	 * Returns the value of the <i>priority</i> variable.
	 * @return The priority of the single passenger.
	 */
	public int getPriority() {
		return this.priority;
	}
	/**
	 * Calculates the priority of the single passenger based on age, ticket type, prioritary embarking and special needs, according to the task.
	 */
	public void setPriority() {
		if(m == null)
			return;
		
		priority = 0;
		priority += (m.getAge() < 2) ? 20 : 0;
		priority += (m.getAge() >= 2 && m.getAge() < 5) ? 10 : 0;
		priority += (m.getAge() >= 5 && m.getAge() < 10) ? 5 : 0;
		priority += (m.getAge() >= 60) ? 15 : 0;

		char c = m.getTicketType().charAt(0);
		priority += (c == 'b') ? 35 : 0;
		priority += (c == 'p') ? 20 : 0;
		
		this.priority += (m.getPrioritaryEmbarking()) ? 30 : 0;
		this.priority += (m.getSpecialNeeds()) ? 100 : 0;
	}
}