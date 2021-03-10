
public class WordTokenizer implements Tokenizer {
	public String[] str_array;
	public int idx;
	
	public WordTokenizer(String s) {
		this.str_array = s.split(" ");
		this.idx = 0;
	}
	@Override
	public String getNext() {
		if(str_array[idx] != null)
			return this.str_array[++idx];
		return null;
	}
}
