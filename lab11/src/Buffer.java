import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
	static final int CAPACITY = 10;
	LinkedList<Integer> intList = new LinkedList<Integer>();

	Lock lock = new ReentrantLock();
	Condition notEmpty = lock.newCondition();
	Condition notFull = lock.newCondition();

	public void write(int value) {
		lock.lock();
		try {
			while(intList.size() == CAPACITY) {
				notFull.await();
				System.out.println("Wait for notFull condition");
			}
			
				intList.offer(value);
				notEmpty.signal();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {			
			lock.unlock();
		}
	}
	
	
	
	public int read() {
		int x = -1;
		lock.lock();
		try {
			while(intList.isEmpty()) {
				notEmpty.await();
				System.out.println("\t\t\tWait for notEmpty condition");
			}
			x = intList.remove();
			notFull.signal();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {			
			lock.unlock();
		}
		return x;
	}
}