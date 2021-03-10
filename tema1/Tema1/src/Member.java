/**
 *	Contains information about a single passenger or a member of a group / family.
 * 	@author Bogdan-Andrei Buga<br> Group 322CB 
 * <br>Automatic Control and Computer Science
 * <br>Polytechnic University of Bucharest
 */
public class Member extends Ticket {
	protected String name;
	protected int age;
	
	// setters
	/**
	 * Sets the name of the respective member.
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets the new age of the respective member.
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// getters
	/**
	 * Returns the value of the <i>name</i> variable.
	 * @return The name of the member.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the value of the <i>age</i> variable.
	 * @return The age of the member.
	 */
	public int getAge() {
		return age;
	}
	
	// Member constructor
	/**
	 * Builds a new ticket with the following parameters:
	 * @param name the name of the member
	 * @param age the age of the member
	 * @param tt the ticket type
	 * @param pe if this member has prioritary embarking
	 * @param sn if this member has any special needs
	 */
	public Member(String name, int age, String tt, boolean pe, boolean sn) {
		super(tt, pe, sn);
		this.setName(name);
		this.setAge(age);
	}
}