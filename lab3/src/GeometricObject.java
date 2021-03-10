import java.util.Date;

//@SuppressWarnings("rawtypes")
public abstract class GeometricObject implements Comparable<Object>{
	private String color;
	private boolean filled;
	private Date dateCreated;
	
	protected GeometricObject() {
		this.color = "red";
		this.filled = false;
		this.dateCreated = new Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		this.dateCreated = new Date();
	}
	
	protected String getColor() {
		return this.color;
	}
	
	protected void setColor(String color) {
		this.color = color;
	}
	
	protected boolean isFilled() {
		return this.filled;
	}
	
	protected void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	protected Date getDateCreated() {
		return this.dateCreated;
	}
	
	protected abstract double getArea();
	protected abstract double getPerimeter();
	protected abstract void display();
	
	public int compareTo(Object o) {
		int dif = (int)(this.getPerimeter() - ((GeometricObject)o).getPerimeter());
		if(dif != 0)
			dif /= Math.abs(dif);
		return dif;
	}
	
}
