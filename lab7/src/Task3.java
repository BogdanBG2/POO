
public class Task3 {
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for(int i = 1; i < list.length; ++i)
			if(max.compareTo(list[i]) < 0)
				max = list[i];
		return max;
	}
	
	public static void main(String[] args) {
		Integer[] list = new Integer[5];
		for(int i = 0; i < 5; ++i)
			list[i] = 15 + 2*i - i*i;
		Task2.printArray(list);
		System.out.println("Max(list) = " + max(list));
	}
}
