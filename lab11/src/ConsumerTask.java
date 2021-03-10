import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerTask implements Runnable {
	ArrayBlockingQueue<Integer> b;
	public ConsumerTask(ArrayBlockingQueue<Integer> b) {
		this.b = b;
	}
	@Override
	public void run() {
		try {
			System.out.println(this.b.take() + " a fost preluat de consumator");
			Random r = new Random();
			Thread.sleep(r.nextInt(1000));
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
