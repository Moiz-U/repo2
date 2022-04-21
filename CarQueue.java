import java.util.PriorityQueue;
import java.util.Random;

public class CarQueue {

	Random ran = new Random();
	PriorityQueue<Integer> i = new PriorityQueue<Integer>();
	private int output;

	public CarQueue() {

		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));
		i.add(ran.nextInt(4));

	}

	public void addToQueue() {

		class ARunnable implements Runnable {

			public void run() {

				try {
					i.add(ran.nextInt(4));
					i.add(ran.nextInt(4));
					i.add(ran.nextInt(4));
					i.add(ran.nextInt(4));
					i.add(ran.nextInt(4));
					i.add(ran.nextInt(4));
					i.add(ran.nextInt(4));

				} finally {

				}
			}
		}
		Runnable r = new ARunnable();
		Thread t = new Thread(r);

		t.start();
	}

	public int deleteQueue() {

		class ARunnable implements Runnable {

			public void run() {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

				}

				try {
					if (i.size() < 20) {
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));

						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
						i.add(ran.nextInt(4));
					}

					else if (!i.isEmpty()) {
						output = i.remove();
					}

				} finally {

				}
			}

		}
		Runnable r = new ARunnable();
		Thread t = new Thread(r);

		t.start();

		return output;

	}

}