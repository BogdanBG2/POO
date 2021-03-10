public class Circle extends GeometricObject{
	
	private double radius;
	private final double pi = 3.14;
	
	public Circle(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}
	
	public double getArea() {
		return pi * this.radius * this.radius;
	}
	
	public double getPerimeter() {
		return 2 * pi * this.radius;
	}
	
	public void display() {
		System.out.println("Circle displayed of radius: " + radius);
	}
	
	public static void main(String[] args) {
		Circle c = new Circle("blue", true, 6.85);
		c.display();
		System.out.println("Area: " + c.getArea());
		System.out.println("Perimeter: " + c.getPerimeter());
	}
}