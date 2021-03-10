import java.util.Scanner;

public class Biblioteca {
	public Carte[] colectie;
	
	public static void main(String[] args) {
		Biblioteca b = new Biblioteca();		
		b.colectie = new Carte[8];
		
		int i;
		for(i = 0; i < b.colectie.length; i++) {
			b.colectie[i] = new Carte();
			b.colectie[i].setNrPg(80);
			b.colectie[i].setEditura("RomPress");
		}
		
		b.colectie[0].setAutor("Eminescu");
		b.colectie[0].setTitlu("Luceafarul");
		
		b.colectie[1].setAutor("Caragiale");
		b.colectie[1].setAutor("O scrisoare pierduta");
		
		b.colectie[2].setAutor("Creanga");
		b.colectie[2].setTitlu("Harap-Alb");
		
		b.colectie[3].setAutor("Barbu");
		b.colectie[3].setTitlu("Ciuperca senila");
		
		b.colectie[4].setAutor("Sorescu");
		b.colectie[4].setTitlu("Iona");
		
		b.colectie[5].setAutor("Eliade");
		b.colectie[5].setTitlu("MayTrey");
		
		b.colectie[6].setAutor("Petrescu");
		b.colectie[6].setTitlu("Cele 2 nopti");
		
		b.colectie[7].setAutor("Arghezi");
		b.colectie[7].setTitlu("Testament");
		

		
		System.out.println("Ce carte ati vrea sa imprumutati?");
		Scanner s = new Scanner(System.in);
		Verificari v = new Verificari();
		Carte c = new Carte();
		
		c.carteNoua(s);
		boolean gasit = false;
		for(i = 0; i < b.colectie.length && gasit == false; i++)
			if(v.dubluExemplar(c, b.colectie[i]))
				gasit = true;
		
		if (gasit == true)
			System.out.println("Imediat. O avem in colectie.");
		else
			System.out.println("Ne pare rau, dar nu avem aceasta carte.");
		
		s.close();
	}
}
