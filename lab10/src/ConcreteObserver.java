import java.util.HashMap;

public class ConcreteObserver implements Observer {
	
	HashMap<String, String> dictionary;
	public ConcreteObserver() {
		this.dictionary = new HashMap<String, String>();
		dictionary.put("mere", "apples");
		dictionary.put("are", "has");
		dictionary.put("am", "have");
		dictionary.put("Eu", "I");
		dictionary.put("prune", "plums");
		dictionary.put("caise", "apricots");
		dictionary.put("cartofi", "potatoes");
		dictionary.put("febra", "fever");
		dictionary.put("prune", "plums");
		dictionary.put("restanta", "a wasted summer");
	}
	
	public void translateMessage(String m) {
		String[] words = m.split(" ");
		for(int i = 0; i < words.length; ++i) {
			if(dictionary.containsKey(words[i]))
				words[i] = dictionary.get(words[i]);
			System.out.print(words[i] + " ");
		}
		System.out.println();
	}
	
	@Override
	public void update(String m) {
		System.out.println("'" + m + "' has been added in the message list.");
	}
}
