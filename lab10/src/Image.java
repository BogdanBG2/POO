
public class Image {
	int width;
	int height;
	int rotation;
	int blurred;
	
	public Image(int w, int h) {
		this.width = w;
		this.height = h;
		this.rotation = 0;
		this.blurred = 0;
	}
	public void resize(int w1, int h1) {
		this.width = w1;
		this.height = h1;
	}
	public void rotate() { // with 90 degrees counter-clockwise
		int aux = this.width;
		this.width = this.height;
		this.height = aux;
	}
}