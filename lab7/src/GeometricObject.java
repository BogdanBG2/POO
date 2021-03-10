
public abstract class GeometricObject implements Comparable<Object> {
	abstract double getArea();
	abstract void display();
	
	public int compareTo(Object o) {
		int diff = (int)(this.getArea() - ((GeometricObject)o).getArea());
		diff /= (diff != 0) ? Math.abs(diff) : 1;
		return diff;
	}
}
