
public class LowerCaseTokenizer extends TokenizerDecorator {

	public LowerCaseTokenizer(WordTokenizer t) {
		super(t);
	}
	public String getNext() {
		return this.tok.getNext().toLowerCase();
	}
}
