public class Rectangle extends GeometricObject{
	
	private double width;
	private double height;

	public Rectangle(String color, boolean filled, double width, double height) {
		super(color, filled);
		this.height = height;
		this.width = width;
	}
	
	public double getArea() {
		return this.height * this.width;
	}
	
	public double getPerimeter() {
		return 2 * (this.height + this.width);
	}
	
	public void display() {
		System.out.println("Rectangle displayed of dimensions: " + width + " and " + height);
	}
	
	public static void main(String[] args) {
		Rectangle d = new Rectangle("green", true, 5.5, 8.75);
		d.display();
		System.out.println("Area: " + d.getArea());
		System.out.println("Perimeter: " + d.getPerimeter());
	}

}
