

public class Rectangle extends GeometricObject{
	int width;
	int height;
	public Rectangle(int w, int h) {
		super();
		this.width = w;
		this.height = h;
	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	void display() {
		System.out.println("Rectangle with the dimensions of " 
			+ width + " * " + height);
	}
}

