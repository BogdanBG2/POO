public class Octagon extends GeometricObject implements Cloneable {
	private double latura;
	
	public Octagon(String color, boolean filled, double latura) {
		super(color, filled);
		this.latura = latura;
	}
	
	public double getArea() {
		return this.latura * this.latura * (2 + 4 * Math.sqrt(2));
	}
	
	public double getPerimeter() {
		return 8 * this.latura;
	}
	
	public void display() {
		System.out.println("Octagon displayed with edge length of " + this.latura);
		System.out.println("Perimeter: " + this.getPerimeter());
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Octagon o = new Octagon("Yellow", false, 10);
		o.display();
		Object o2 = o.clone();
		if(o.compareTo(o2) == 0)
			System.out.println("The two objects are identical!");	
	}
}
