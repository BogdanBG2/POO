import java.util.ArrayList;

public class GenericStack<E> {
	ArrayList<E> list;
	
	public GenericStack() {
		this.list = new ArrayList<E>();
	}
	int getSize() {
		return this.list.size();
	}
	void push(E o) {
		this.list.add(o);
	}
	
	E peek() {
		return this.list.get(list.size() - 1);
	}
	
	E pop() {
		E result = this.peek();
		this.list.remove(result);
		return result;
	}
	
	boolean isEmpty() {
		return this.list.isEmpty();
	}
	
	public static <E> void printStack(GenericStack<E> st) {
		for(E o : st.list)
			System.out.print(o + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		GenericStack<Integer> s1 = new GenericStack<Integer>();
		GenericStack<Double> s2 = new GenericStack<Double>();
		GenericStack<String> s3 = new GenericStack<String>();
		
		s1.push(4);
		s1.push(9);
		s1.push(17);
		s1.push(22);
		System.out.println("s1: " + s1.getSize() 
		+ " " + s1.peek() + " " + s1.isEmpty());
		
		s2.push(2.1);
		s2.push(1.7);
		s2.push(3.9);
		s2.push(0.4);
		s2.push(10.55);
		System.out.println("s2: " + s2.getSize() 
		+ " " + s2.peek() + " " + s2.isEmpty());
	
		s3.push("This");
		s3.push("is a");
		s3.push("queue");
		System.out.println("s3: " + s3.getSize() 
		+ " " + s3.peek() + " " + s3.isEmpty());
		System.out.println();
		
		GenericStack.printStack(s1);
		GenericStack.printStack(s2);
		GenericStack.printStack(s3);
		
	}
}
