
public abstract class Pizza {
	private int size;
	private int price;
	
	public int getSize() { return size; }
	public int getPrice() { return price; }
	
	public void setSize(int size) { this.size = size; }
	public void setPrice(int price) { this.price = price; }
	
	public Pizza(int size, int price) { 
		this.setSize(size);
		this.setPrice(price);
	}

	public abstract String toString();
}
