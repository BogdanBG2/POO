class Profesor extends Persoana {
	String materie;
	
	public Profesor() {}
	public Profesor(String nume, String materie) {
		super(nume);
		this.materie = materie;
	}
	
	public void preda() {
		System.out.println(this.nume + " preda");
	}
	
	public String toString() {
		return "Profesor: " + super.toString() + ", " + materie;
	}
	
	public static void main(String[] args) {
		Profesor p = new Profesor("Ionescu", "POO");
		System.out.println(p.toString());
	}
}