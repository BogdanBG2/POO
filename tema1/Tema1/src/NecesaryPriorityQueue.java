import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class contains a heap (represented as an array),
 * a size variable, which represents the number of elements in the heap
 * and a writer to print the priority queue in a given file.
 * <br> I've named this class <i>NecesaryPriorityQueue</i>
 * in order to avoid the overriding of the already existing <i>PriorityQueue</i> class.
 */
public class NecesaryPriorityQueue {
	Passenger[] queue;
	private int size = 0;
	PrintWriter writer;
	/**
	 * Builds a heap which can have at most <i>maxsize</i> elements
	 * that would be printed in the <i>output</i> file.
	 * <br>Note: The array is implemented from 0 to ((no. of elements) - 1).
	 * @param maxsize maximum number of elements in the array
	 * @param output output file
	 * @throws FileNotFoundException
	 */
	public NecesaryPriorityQueue(int maxsize, File output) throws FileNotFoundException {
		this.queue = new Passenger[maxsize];
		this.writer = new PrintWriter(output);
	}
	/**
	 * @return The index of the parent node of queue[i].
	 * @param i the index of the element
	 */
	public int parent(int i) { 
        return (i - 1)/ 2; 
    }
	/**
	 * @return The index of the left node of queue[i].
	 * @param i the index of the element
	 */
	public int leftChild(int i) { 
        return (2 * i + 1); 
    }
	/**
	 * @return The index of the right node of queue[i].
	 * @param i the index of the element
	 */
	public int rightChild(int i) { 
        return (2 * i + 2); 
    }
	/**
	 * If the parent's priority is lower than the priority of either one of his children,
	 * then the parent and the child with the greater priority will change their values.
	 * This procedure continues until the parent's priority is greater or equal to the priorities of his children, 
	 * or until the parent doesn't have any children.
	 * @param i the index of the heap to be evaluated
	 */
	public void heapify(int i) {
		if(i > size || i < 0)
			return;

		int max = i,
			left = leftChild(i),
			right = rightChild(i);

		max = (left < size && queue[i].compareTo(queue[left]) < 0) ? left : i;
		max = (right < size && queue[max].compareTo(queue[right]) < 0) ? right : max;

		if(max != i) {
			Passenger aux = queue[i];
	        queue[i] = queue[max];
	        queue[max] = aux;
			heapify(max);
		}
	}
	
	/**
	 * Adds a new passenger <i>p</i> with the priority <i>priority</i> in the priority queue.
	 * If this new passenger has a priority greater than his parent, then these 2 will change places in the queue.
	 * This procedure repeats until the inserted value is higher in the queue than 
	 * all of his parents with a lower priority than his.
	 * @param p the passenger to be inserted
	 * @param priority the coresponding priority
	 */
	public void insert(Passenger p, int priority) {
		size++;
		queue[size - 1] = p;
		int i = size - 1;

		while(priority > queue[parent(i)].getPriority()) {
			Passenger aux = queue[i];
	        queue[i] = queue[parent(i)];
	        queue[parent(i)] = aux;
			i = parent(i);
		}
	}
	
	/**
	 * Removes the root of the queue. All the other elements will stay the same,
	 * but the new root will be the last element from the initial queue array.
	 * This new root will be "heapified", in order to maintain the <u>heap</u> priority of the array.
	 */
	public void embark() {
		queue[0] = queue[--size];
		heapify(0);
	}
	
	/**
	 * Deletes a given passenger from the queue and rearranges
	 * the queue as a max-heap.
	 * @param p the passenger to be removed
	 */
	public void delete(Passenger p) {
		for(int i = 0; i < size; ++i) // tries to find the passenger
			if(p.getID() == queue[i].getID()) {
				queue[i] = queue[--size];
				heapify(i);
				break; // once we found and deleted the passenger, we stop 
			}
	}
	
	/**
	 * This is a recursive function which prints the <i>i</i>-th element of the array.
	 * Once it has been printed, this function will be called in preorder (root - left - right),
	 * so we can print alll the elements of the array / queue.
	 * @param i the index from which the program starts printing the queue elements
	 * @throws IOException
	 */
	public void print(int i) throws IOException {
		if(i >= size)
			return;
		if(i == 0) 
			writer.print(queue[i].getID());
		else 
			writer.print(" " + queue[i].getID());
		
		print(leftChild(i));
		print(rightChild(i));
	}
	
	/**
	 * Lists all the elements from the heap, starting with its root, in preorder.
	 * @throws IOException
	 */
	public void list() throws IOException {
		print(0);
	}
	
	/**
	 * Closes the used writer.
	 */
	public void closeWriter() {
		this.writer.close();
	}
}
