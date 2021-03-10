
public abstract class ImageCommand implements Command {
	Image img;
	public abstract void undo();
	
	public void printImage() {
		System.out.println(
				"Size: " + this.img.width + "x" + this.img.height
				+ ", Rotation: " + this.img.rotation
				+ ", Bluured? (as number): " + this.img.blurred);
	}
}
