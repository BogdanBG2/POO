import java.util.ArrayList;
import java.util.Collections;

public class Task4 {
	public static void maximumArea(ArrayList<? extends GeometricObject> list) {
		ArrayList<GeometricObject> aux = new ArrayList<>(list);
		Collections.sort(aux, Collections.reverseOrder());
		System.out.println("Max area = " + aux.get(0).getArea());
	}
	public static void main(String[] args) {
		ArrayList<GeometricObject> list = new ArrayList<GeometricObject>();
		list.add(new Square(10));
		list.add(new Rectangle(12, 8));
		list.add(new Circle(5));
		
		for(GeometricObject o : list)
			o.display();
		Task4.maximumArea(list);
	}
}
