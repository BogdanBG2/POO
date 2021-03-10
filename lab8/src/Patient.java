import java.util.Iterator;
import java.util.PriorityQueue;

public class Patient implements Comparable<Patient>{
	String name;
	int priority;

	public Patient(String n, int p) {
		this.name = n;
		this.priority = p;
	}
	
	@Override
	public int compareTo(Patient patient) {
		int diff = patient.priority - this.priority; // sortare descrescatoare
		diff /= (diff != 0) ? Math.abs(diff) : 1;
		return diff;
	}
	
	public String toString() {
		return this.name + ": " + this.priority;
	}

	public static void main(String[] args) {
		PriorityQueue<Patient> pq = new PriorityQueue<Patient>();
		pq.add(new Patient("Mihai", 24));
		pq.add(new Patient("Alex", 27));
		pq.add(new Patient("Stefan", 45));
		pq.add(new Patient("Laurentiu", 30));
		
		// EXEMPLU 1
		pq.remove();
		Iterator<Patient> i = pq.iterator();
		while(i.hasNext())
			System.out.println(i.next().toString());
		System.out.println("\n");
		
		// EXEMPLU 2
		pq.remove();
		i = pq.iterator();
		while(i.hasNext())
			System.out.println(i.next().toString());
	}
}
