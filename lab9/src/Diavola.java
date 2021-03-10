
public class Diavola extends Pizza {
	public Diavola(int size, int price) {
		super(size, price);
	}

	@Override
	public String toString() {
		return "Diavola: diametru de " + this.getSize() 
		+ ", pretul fiind " + this.getPrice() + " (de) lei";
	}
}
