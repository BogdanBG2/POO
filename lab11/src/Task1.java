import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
	public static void main(String[] args) {
		Buffer b = new Buffer();
		b.intList.offer(2);
		b.intList.offer(4);
		b.intList.offer(7);
		b.intList.offer(11);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);		
		executor.execute(new ProducerTask(b));
		executor.execute(new ConsumerTask(b));
		executor.shutdown();
	}
}
