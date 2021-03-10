
public class Circle {
	double radius;
	static int number = 0;
	
	public void setRadius(double newRadius) {
		if(newRadius <= 0)
			throw new IllegalArgumentException("Error: radius must be positive");
		this.radius = newRadius;
	}
	
	public Circle(double newRadius) throws InvalidRadiusException, IllegalArgumentException {
		this.setRadius(newRadius);
		number++;
	}
	
	public void printArea() {
		System.out.println("Area = " + Math.PI * radius * radius);
	}
	
	public static int binaryToDecimal(String binaryString) {
		for(int i = 0; i < binaryString.length(); ++i)
			if(binaryString.charAt(i) != '1' && binaryString.charAt(i) != '0') {
				throw new NumberFormatException("b");
			}
		return Integer.parseInt(binaryString, 2);
	}
	
	public static int hexToDecimal(String hexString) {
			if(!hexString.matches("-?[0-9a-fA-F]+"))
				throw new NumberFormatException("h");
	
		return Integer.parseInt(hexString, 16);
	}
			
	public static void main(String[] args) throws InvalidRadiusException {
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(4);
		Circle c3 = new Circle(5);	
		System.out.println(number + " circles");
		
		c1.printArea();
		c2.printArea();
		c3.printArea();
		
		System.out.println("10100 -> " + binaryToDecimal("10100"));
		System.out.println("322CB -> " + hexToDecimal("322CB"));
	}
}
