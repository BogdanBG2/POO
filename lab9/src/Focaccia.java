
public class Focaccia extends Pizza{
	public Focaccia(int size, int price) {
		super(size, price);
	}

	@Override
	public String toString() {
		return "Focaccia: diametru de " + this.getSize() 
		+ ", pretul fiind " + this.getPrice() + " (de) lei";
	}
}
