import java.util.HashMap;

public class BlurCommand extends ImageCommand {

	int initial_blur;
	@Override
	public void undo() {
		this.img.blurred = this.initial_blur;
	}

	@Override
	public void execute(HashMap<String, Integer> param) {
		int b = param.get("BLUR");
		this.initial_blur = this.img.blurred;
		this.img.blurred = b;
	}
}
