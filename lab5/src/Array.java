import java.util.Random;

public class Array {
	int[] v;
	
	public Array() {
		this.v = new int[50];
		Random r = new Random();
		for(int i = 0; i < 50; ++i)
			v[i] = Math.abs(r.nextInt() % 50);
	}
	public void printArray() {
		System.out.print(v[0]);
		for(int i = 1; i < 50; ++i)
			System.out.print(" " + v[i]);
		System.out.println();
	}
	
	public int elementAt(int i) {
		if(i >= 50)
			throw new ArrayIndexOutOfBoundsException();
		return v[i];
	}
	public static void main(String[] args) {
		Array a = new Array();
		a.printArray();
		System.out.println(a.elementAt(1));
	}
}
