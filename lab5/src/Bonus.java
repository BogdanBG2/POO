
public class Bonus {
	int i;
	int[] a;
	public Bonus() {
		i = 1;
	}
	
	public void method1() {
		a = new int[(int)Math.pow(10, 10)];
	}
	
	public void method2() { // stack overflow
		if(i == 1)
			this.method2();
	}
	
	public static void main(String[] args) {
		Bonus b = new Bonus();
		b.method1();
	}
}
