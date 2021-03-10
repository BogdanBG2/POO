import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Student {
	String name;
	float average;
	
	public Student(String n, float a) {
		this.name = n;
		this.average = a;
	}
	
	public String toString() {
		return this.name + " are media " + this.average;
	}
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student("Mihai", (float) 9.7));
		set.add(new Student("Alexa", (float) 9.2));
		Iterator<Student> i = set.iterator();
		while(i.hasNext())
			System.out.println(i.next().toString());
	}

}
