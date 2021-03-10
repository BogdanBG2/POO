
public class Verificari {
	
	public boolean dubluExemplar(Carte c1, Carte c2) {
		if(c1.getAutor().equals(c2.getAutor())
		&& c1.getTitlu().equals(c2.getTitlu())
		&& c1.getEditura().equals(c2.getEditura())
		&& c1.getNrPg() == c2.getNrPg())
			return true;
		return false;
	} // true daca cartile sunt complet identice, false altfel
	
	public Carte carteaMaiGroasa(Carte c1, Carte c2) {
		if(c1.getNrPg() >= c2.getNrPg())
			return c1;
		return c2;
	}
}
