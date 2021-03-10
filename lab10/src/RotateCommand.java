import java.util.HashMap;

public class RotateCommand extends ImageCommand{
	int initial_width;
	int initial_height;
	int initial_rotation;

	@Override
	public void undo() {
		this.img.rotation = this.initial_rotation;
		this.img.width = this.initial_width;
		this.img.height = this.initial_height;
	}

	@Override
	public void execute(HashMap<String, Integer> param) {
		int r = param.get("DEG");
		this.initial_rotation = this.img.rotation;
		this.img.rotation = r;
	
		this.initial_width = this.img.width;
		this.img.width = (int) Math.abs(
				this.img.width * Math.cos((double)r / 180 * Math.PI)
				+ this.img.height * Math.sin((double)r / 180 * Math.PI));
		
		this.initial_height = this.img.height;
		this.img.height = (int) Math.abs(
				this.img.height * Math.cos((double)r / 180 * Math.PI)
				+ this.initial_width * Math.sin((double)r / 180 * Math.PI));
		
	}
}