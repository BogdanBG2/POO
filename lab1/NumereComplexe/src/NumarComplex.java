
public class NumarComplex {
	
	float re = 0;
	float im = 0;
	
	public NumarComplex() {} // constructor default
	
	public NumarComplex(float re, float im) { // constructor citit
		this.re = re;
		this.im = im;
	}
	
	public void printNC() { // afisare standard
		System.out.println("(" + this.re + ", " + this.im + ")");
	}
	
	public double modul() {
		return Math.sqrt(re * re + im * im);
		
	}
}
