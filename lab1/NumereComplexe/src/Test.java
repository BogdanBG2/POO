public class Test {
	public static void main(String[] args) {
		NumarComplex a = new NumarComplex(3, 0);
		NumarComplex b = new NumarComplex(0, -4);
		
		// toate operatiile sunt definite in clasa 'Operatii'
		Operatii oper = new Operatii();
		
		NumarComplex c = oper.add(a, b);
		c.printNC();
		System.out.println("|c| = " + c.modul());

		NumarComplex d = oper.multiply(a, b);
		d.printNC();
		System.out.println("|d| = " + d.modul());
	}
}
