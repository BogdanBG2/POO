
public class Task1 {

	public static void main(String[] args) {
		MessageSet ms = new MessageSet();
		ms.registerObserver(new ConcreteObserver());
		
		ms.addMessage("Ana are mere");
		ms.addMessage("Adrian are restanta");
		ms.addMessage("Catalin are cartofi");
		ms.addMessage("Ion are febra");
		for(String m : ms.messages)
			((ConcreteObserver)ms.observers.get(0))
			.translateMessage(m);
	}
}
