
public class Circle extends GeometricObject {

	int radius;
	public Circle(int r) {
		super();
		this.radius = r;
	}

	@Override
	double getArea() {
		return radius * radius * Math.PI;
	}

	@Override
	void display() {
		System.out.println("Circle with the radius of " + radius);
	}
}
