import java.util.ArrayList;

public class MyStack {
	ArrayList<Object> list;
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public Object peek() {
		return list.get(list.size() - 1);
	}
	
	public void pop() {
		list.remove(list.size() - 1);
	}
	
	public void push(Object x) {
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
		MyStack s = new MyStack();
		s.list = new ArrayList<Object>();
		System.out.println(s.list.isEmpty()); // e initializata null -> 'true'
		s.push(10);
		s.push(34);
		s.push(49);
		System.out.println(s.toString() + " ---- " + s.getSize());
		System.out.println("Varf: " + s.peek());
		s.pop();
		System.out.println(s.toString());
		System.out.println("65? Index: " + s.search(65));
		System.out.println("34? Index: " + s.search(34));
	}
}
