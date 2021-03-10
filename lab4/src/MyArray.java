public class MyArray {
	int[] arr;
	int size = 0;
	public MyArray(int n) {
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = i + 1;
		size = n;
	}
	class ArrayIterator {
		int index;
		
		public ArrayIterator() {
			this.index = 0;
		}
		public ArrayIterator(int i) {
			if(i < size)
				this.index = i;
			else
				System.out.println("Error: chosen index is out of bounds!");
		}
		
		public boolean hasNext() {
			return (index < size - 1);
		}
		public boolean hasPrevious() {
			return (index > 0);
		}
		
		int next() {
			if(hasNext() == false)
				return -1;
			return arr[index + 1];
		}
		int nextIndex() {
			if(hasNext() == false)
				return -1;
			return (index + 1);
		}
		int previous() {
			if(hasPrevious() == false)
				return -1;
			return arr[index - 1];
		}
		int previousIndex() {
			if(hasPrevious() == false)
				return -1;
			return (index - 1);
		}
	}
	
	void printForward() {
		ArrayIterator iter = new ArrayIterator();
		System.out.print(arr[iter.index]); // pentru primul element
		for(; iter.hasNext(); iter.index = iter.nextIndex())
			System.out.print(" " + iter.next());
		System.out.println();
	}
	void printBackward() {
		ArrayIterator iter = new ArrayIterator(size - 1);
		System.out.print(arr[iter.index]); // pentru primul element
		for(; iter.hasPrevious(); iter.index = iter.previousIndex())
			System.out.print(" " + iter.previous());
		System.out.println();
	}
	int firstMultiple(int k) {
		ArrayIterator iter = new ArrayIterator();
		for(; iter.hasNext(); iter.index = iter.nextIndex())
			if(arr[iter.index] % k == 0)
				return iter.index;
		if(arr[iter.index] % k == 0)
			return iter.index;
		return -1;
	}
	
	public static void main(String[] args) {
		MyArray a = new MyArray(20);
		a.printForward();
		System.out.println("Primul multiplu de 6 se afla la indicele " + a.firstMultiple(6));
		a.printBackward();
	}
}
