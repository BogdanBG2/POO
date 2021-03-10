import java.util.ArrayList;

public class StopWordsTokenizer extends TokenizerDecorator {

	ArrayList<String> wd_list;
	public StopWordsTokenizer(WordTokenizer t, ArrayList<String> wd_list) {
		super(t);
		this.wd_list = new ArrayList<String>();
	}

	public String getNext() {
		return null;
	}
}
