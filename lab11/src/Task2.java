import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2 {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);		
		executor.execute(new ProducerTask(abq));
		executor.execute(new ConsumerTask(abq));
		executor.shutdown();
	}
}
