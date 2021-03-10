
public class Bonus {
	public static <E extends Comparable<E>> void selectionSort(E[] list) {
		int n = list.length;
		int min, j;
		E aux;
		for(int i = 0; i < n - 1; ++i) {
			min = i;
			for(j = i + 1; j < n; ++j)
				if(list[j].compareTo(list[min]) < 0)
					min = j;
			aux = list[i];
			list[i] = list[min];
			list[min] = aux;
		}
	}
	
	public static void main(String[] args) {
		Integer[] list = new Integer[5];
		list[0] = 64;
		list[1] = 25;
		list[2] = 12;
		list[3] = -22;
		list[4] = 7;
		
		Task2.printArray(list);
		Bonus.selectionSort(list);
		Task2.printArray(list);
	}
}
