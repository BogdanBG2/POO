import java.util.Scanner;

public class Carte {
	private String titlu;
	private String autor;
	private String editura;
	private int numarPagini;

	public Carte() {}
	
	public Carte(String t, String a, String e, int n) {
		this.titlu = t;
		this.autor = a;
		this.editura = e;
		this.numarPagini = n;
	}
	
	// getter-i
	public String getTitlu() { return titlu; }
	public String getAutor() { return autor; }
	public String getEditura() { return editura; }
	public int getNrPg() { return numarPagini; }
	
	// setter-i
	public void setTitlu(String t) { this.titlu = t; }
	public void setAutor(String a) { this.autor = a; }
	public void setEditura(String e) { this.editura = e; }
	public void setNrPg(int n) { this.numarPagini = n; }
	
	// scanner
	public void carteNoua(Scanner s) {
		System.out.print("Titlu: ");
		titlu = s.nextLine();
		
		System.out.print("Autor: ");
		autor = s.nextLine();
		
		System.out.print("Editura: ");
		editura = s.nextLine();
		
		System.out.print("Numar Pagini: ");
		if(s.hasNextInt()) {
			int i = s.nextInt();
			if(i != 0)
				numarPagini = i;
		}
		else 
			numarPagini = -1;
		s.nextLine(); // terminarea citirii
	}
	
	// printer
	public void printCarte() {
		System.out.println("Titlu: " + titlu.toUpperCase());
		System.out.println("Autor: " + autor);
		System.out.println("Editura: " + editura.toLowerCase());
	}
}
