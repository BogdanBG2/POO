public class Upcasting {
	public static void main(String[] args) {
		Persoana[] p = new Persoana[4];
		
		p[0] = new Profesor("Adolf", "Fizica");
		p[1] = new Student("Gigel", 5);
		((Profesor) p[0]).preda(); // task 4
		((Student) p[1]).invata();
		//System.out.println(p[0].toString());	// task 2
		//System.out.println(p[1].toString());
		System.out.println();
		
		p[2] = new Profesor("Iosif", "PC");
		p[3] = new Student("Bula", 10);
		((Profesor) p[2]).preda(); // task 4
		((Student) p[3]).invata();
		//System.out.println(p[2].toString());	// task 2
		//System.out.println(p[3].toString());
	}
}
