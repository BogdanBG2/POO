import java.util.HashMap;

public class ResizeCommand extends ImageCommand {
	int initial_width;
	int initial_height;
	
	@Override
	public void undo() {
		this.img.width = this.initial_width;
		this.img.height = this.initial_height;
	}
	
	@Override
	public void execute(HashMap<String, Integer> param) {
		int w = param.get("HEIGHT");
		int h = param.get("WIDTH");

		this.img.width = w;
		this.initial_width = this.img.height;
		
		this.initial_height = this.img.height;
		this.img.height = h;
		
		
	}
}
