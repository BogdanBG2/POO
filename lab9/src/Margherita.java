
public class Margherita extends Pizza{
	public Margherita(int size, int price) {
		super(size, price);
	}

	@Override
	public String toString() {
		return "Margherita: diametru de " + this.getSize() 
		+ ", pretul fiind " + this.getPrice() + " (de) lei";
	}
}
