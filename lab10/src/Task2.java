import java.util.HashMap;

public class Task2 {
	public static void main(String[] args) {
		ImageCommand rot = new RotateCommand();
		rot.img = new Image(200, 150);
		HashMap<String, Integer> com = new HashMap<>();
		com.put("DEG", 270);
		rot.execute(com);
		rot.printImage();
		rot.undo();
		rot.printImage();
		
		
	}
}
