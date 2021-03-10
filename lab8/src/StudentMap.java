import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentMap {
	Map<Integer, ArrayList<Student>> classroom;
	
	public StudentMap() {
		this.classroom = new HashMap<Integer, ArrayList<Student>>();
		for(int i = 1; i <= 10; ++i)
			this.classroom.put(i, new ArrayList<Student>()); // initializarea listelor necesare
	}
	
	public void add(Student s) {
		int index = Math.round(s.average);
		this.classroom.get(index).add(s);
	}
	
	public static void main(String[] args) {
		StudentMap m = new StudentMap();
		m.add(new Student("Adrian", (float) 6.8));
		m.add(new Student("Alex", (float) 5.4));
		m.add(new Student("Marius", (float) 8.6));
		m.add(new Student("Laura", (float) 9.7));
		
		for(Integer i : m.classroom.keySet())
			if(!m.classroom.get(i).isEmpty())
				for(Student s : m.classroom.get(i))
					System.out.println(s.toString());
	}

}
