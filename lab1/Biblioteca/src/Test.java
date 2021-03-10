import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Carte c1 = new Carte();
		Carte c2 = new Carte();
		Carte c3 = new Carte();
		Verificari v = new Verificari();
		Scanner s = new Scanner(System.in);
		
		c1.carteNoua(s);
		c2.carteNoua(s);
		c3.carteNoua(s);
		
		
		System.out.println("--- Verificari ---");
		System.out.println(v.dubluExemplar(c1, c2));
		System.out.println(v.carteaMaiGroasa(c1, c3).getTitlu());
		System.out.println(v.carteaMaiGroasa(c2, c3).getTitlu());
	
		s.close();
	}

}
