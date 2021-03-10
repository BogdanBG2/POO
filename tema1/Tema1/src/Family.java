import java.util.ArrayList;
/**
 * 	This class is an extension of the previously implemented <i>Passenger</i> class
 * 	and just like <i>Group</i>, it has <b>at least 2</b> members.
 * 	@author Bogdan-Andrei Buga<br> Group 322CB 
 * 	<br>Automatic Control and Computer Science
 * 	<br>Polytechnic University of Bucharest
 *
 */
public class Family extends Passenger {
	ArrayList<Member> f;
	/**
	 * Builds an empty family with the id given as parameter.
	 */
	public Family(String id) {
		super(id);
		this.f = new ArrayList<Member>();
	}
	/**
	 * Adds a new member to an already existing family.<br>
	 * This new member is described by the following parameters:
	 * @param name the name
	 * @param age the age
	 * @param tt the ticket type
	 * @param pe if this member has prioritary embarking
	 * @param sn if this member has any special needs
	 */
	public void addFamilyMember(String name, int age, String tt, boolean pe, boolean sn) {
		f.add(new Member(name, age, tt, pe, sn));
	}

	// getters
	/**
	 * Returns the value of the <i>priority</i> variable.
	 * @return The priority of the family.
	 */
	public int getPriority() {
		return this.priority;
	}

	// setters
	/**
	 * Calculates the priority of the family based on the age, ticket type,
	 * prioritary embarking and special needs of every member of the group, accordind to the task.
	 */
	public void setPriority() {
		priority = 10;
		
		for(Member m : this.f) {
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
}
