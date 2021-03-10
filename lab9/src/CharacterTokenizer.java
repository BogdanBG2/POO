
public class CharacterTokenizer extends TokenizerDecorator {
	int idx;
	public CharacterTokenizer(WordTokenizer t) {
		super(t);
		this.idx = 0;
	}
	public String getNext() {
		String word = this.tok.str_array[this.tok.idx];
		char c = word.charAt(++idx);
		String result = "" + c;
		return result;
	}
}