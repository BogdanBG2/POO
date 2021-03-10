
public class Square extends GeometricObject{
	int side;
	public Square(int s) {
		super();
		this.side = s;
	}

	@Override
	double getArea() {
		return side * side;
	}

	@Override
	void display() {
		System.out.println("Square with the side of " + side);
	}
}

