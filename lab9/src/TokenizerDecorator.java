
public class TokenizerDecorator implements Tokenizer {
	public WordTokenizer tok;
	public TokenizerDecorator(WordTokenizer t) {
		this.tok = t;
	}
	
	@Override
	public String getNext() {
		return tok.getNext();
	}

}
