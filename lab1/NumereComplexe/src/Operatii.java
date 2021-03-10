public class Operatii {
	NumarComplex add(NumarComplex z1, NumarComplex z2) { // adunare
		NumarComplex s = new NumarComplex();
		s.re = z1.re + z2.re;
		s.im = z1.im + z2.im;
		return s;
	}
	
	NumarComplex multiply(NumarComplex z1, NumarComplex z2) { // inmultire
		NumarComplex p = new NumarComplex();
		p.re = z1.re * z2.re - z1.im * z2.im;
		p.im = z1.re * z2.im + z1.im * z2.re;
		return p;
	}
}
