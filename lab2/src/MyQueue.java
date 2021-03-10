import java.util.ArrayList;

public class MyQueue {
	ArrayList<Object> list;
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getLength() {
		return list.size();
	}
	
	public Object front() {
		return list.get(0);
	}
	
	public void dequeue() {
		list.remove(0);
	}
	
	public void enqueue(Object x) {
		list.add(x);
	}
	
	public int search(Object x) {
		return list.indexOf(x);
	}
	
	public String toString() {
		String s = "[";
		if(list.size() == 0) {
			s += "]";
			return s;
		}
		
		for(int i = 0; i < list.size(); ++i) {
			s = s + list.get(i);
			if(i < list.size() - 1)
				s = s + ", ";
			else
				s = s + "]";
		}
		return s;
	}
	
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.list = new ArrayList<Object>();
		System.out.println(q.list.isEmpty()); // e initializata null -> 'true'
		q.enqueue(10);
		q.enqueue(34);
		q.enqueue(49);
		System.out.println(q.toString() + " ---- " + q.getLength());
		System.out.println("Fata: " + q.front());
		q.dequeue();
		q.enqueue(22);
		q.dequeue();
		q.enqueue(73);
		System.out.println(q.toString());
		System.out.println("65? Index: " + q.search(65));
		System.out.println("73? Index: " + q.search(73));
	}
}
