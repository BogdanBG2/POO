import java.util.Random;

public class MyArrayList {
	int[] v;
	int size = 0;
	
	public MyArrayList(int n) {
		this.v = new int[n];
	}

	public MyArrayList() {
		this(10);
	}
	
	public void add(int x) {
		if(size == v.length) {
			int[] copie = new int[2 * v.length];
			System.arraycopy(v, 0, copie, 0, v.length);
			v = copie; // v cel vechi va puncta la v cel nou, adica la copie
		}
		v[size++] = x;
	}
			
	public int get(int i) {
		return v[i];
	}
	
	public int getSize() {
		return size;
	}
	
	public void printArray() {
		System.out.print("v = [");
		int i;
		for(i = 0; i < size - 1; ++i)
			System.out.print(v[i] + ", ");
		System.out.println(v[i] + "]");
	}
	
	public static void main(String[] args) {
		Random generator = new Random();
		MyArrayList l = new MyArrayList(5);
		
		for(int i = 0; i < 11; ++i)
			l.add(generator.nextInt(100));

		System.out.println("------------------------------------------");
		l.printArray();
		System.out.println("------------------------------------------");
		System.out.println("List Size = " + l.getSize());
		System.out.println("Array Size = " + l.v.length);
	}
}
