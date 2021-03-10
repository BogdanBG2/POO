import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerTask implements Runnable {

	//Buffer b;
	ArrayBlockingQueue<Integer> b;
	public ProducerTask(ArrayBlockingQueue<Integer> b) {
		this.b = b;
	}
	@Override
	public void run() {
		try {
			this.b.put(5);
			System.out.println(this.b.peek() + " a fost adaugat de producator");
			Random r = new Random();
			Thread.sleep(r.nextInt(1000));
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}