import java.util.Arrays;

public class Scene {
	GeometricObject[] tablou;
	int idx = 0;
	
	public Scene(int l) {
		this.tablou = new GeometricObject[l];
	}
	
	public void add(GeometricObject o) {
		this.tablou[(this.idx)++] = o;
	}
	
	public void displayAll() {
		GeometricObject o;
		for(int i = 0; i < this.tablou.length; ++i) {
			System.out.print("Figure " + (i+1) + ": ");
			o = this.tablou[i];
			o.display();
			System.out.println("Perimeter: " + o.getPerimeter());
		}
	}
	
	public double areaAll() {
		int s = 0;
		for(GeometricObject o : this.tablou)
			s += o.getArea();
		return s;
	}
	
	public double perimeterAll() {
		int p = 0;
		for(GeometricObject o : this.tablou)
			p += o.getPerimeter();
		return p;
	}
	
	public void sort() {
		Arrays.sort(this.tablou);
	}
	
	public static void main(String[] args) {
		Scene s = new Scene(4);
		int i;
		for(i = 0; i < 4; ++i)
			if(i % 2 == 0)
				s.add(new Rectangle("Cyan", true, (i+6), 2*i));
			else
				s.add(new Circle("White", true, i));
		
		s.displayAll();
		System.out.println();
		
		System.out.println("Total area: " + s.areaAll());
		System.out.println("Total perimeter: " + s.perimeterAll());
		
		for(i = 0; i < 4; ++i)
			System.out.println("Figure " + (i+1) + " was created at " + s.tablou[i].getDateCreated().toString());
		System.out.println();
		
		s.sort();
		s.displayAll();
	}
}
