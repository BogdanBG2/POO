
public class Task2 {
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		int l = 0, r = list.length - 1;
		int m;
		while(l <= r) {
			m = l + (r - l) / 2;
			if(list[m].compareTo(key) == 0)
				return m;
			if(list[m].compareTo(key) < 0)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> void printArray(E[] list) {
		for(int i = 0; i < list.length; ++i)
			System.out.print(list[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer key = 3;
		Integer[] list = new Integer[5];
		for(int i = 0; i < 5; ++i)
			list[i] = 1 + i + i;
		printArray(list);
		System.out.println("Index we find " + key + " : " + binarySearch(list, key));
	}
}
