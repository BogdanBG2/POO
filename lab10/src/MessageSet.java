import java.util.ArrayList;

public class MessageSet implements Subject{
	ArrayList<String> messages;
	ArrayList<Observer> observers;

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		if(this.observers.indexOf(o) >= 0)
			this.observers.remove(this.observers.indexOf(o));
	}

	@Override
	public void notifyObservers(String m) {
		for(Observer o : this.observers)
			o.update(m);
	}
	
	public MessageSet() {
		this.messages = new ArrayList<String>();
		this.observers = new ArrayList<Observer>();
	}
	
	public void addMessage(String m) {
		this.messages.add(m);
		this.notifyObservers(m);
	}
}