public class Student extends Persoana {
	int nota;
	
	public Student() {}
	public Student(String nume, int nota) {
		super(nume);
		this.nota = nota;
	}
	
	public void invata() {
		System.out.println(this.nume + " invata");
	}
	
	public String toString() {
		return "Student: " + super.toString() + ", " + nota;
	}
	
	public static void main(String[] args) {
		Student s = new Student("Popescu", 8);
		System.out.println(s.toString());

	}
}
