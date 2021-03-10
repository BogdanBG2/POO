
public class Capriciosa extends Pizza {

	public Capriciosa(int size, int price) {
		super(size, price);
	}

	@Override
	public String toString() {
		return "Capriciosa: diametru de " + this.getSize() 
		+ ", pretul fiind " + this.getPrice() + " (de) lei";
	}

}
