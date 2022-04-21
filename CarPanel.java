import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * This component draws two car shapes.
 */
public class CarPanel extends JComponent {
	private Car cars;
	private int xaxis;
	private int yaxis;
	private int delay;
	private CarQueue carQueue;
	private int direction;

	CarPanel(int x1, int y1, int d, CarQueue queue) {
		delay = d;
		xaxis = x1;
		yaxis = y1;
		cars = new Car(xaxis, yaxis, this);
		carQueue = queue;
	}

	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {

					for (int i = 0; i < 100; i++) {

						direction = carQueue.deleteQueue();

						if (direction == 0) {
							// up
							if (!(yaxis < 0 && yaxis > 300)) {
								yaxis = yaxis + 10;
							}

						}
						if (direction == 1) {
							// down

							if (!(yaxis > 300 && yaxis < 0)) {
								yaxis = yaxis - 10;
							}

						}
						if (direction == 2) {
							// left

							if ((xaxis > 0)) {
								xaxis = xaxis - 10;
							}

						}
						if (direction == 3) {
							// right
//                           System.out.println(x);
							if (xaxis < 180) {
								xaxis = xaxis + 20;
							}

						}
						repaint();
						Thread.sleep(delay * 100);

					}
				} catch (InterruptedException exception) {

					carQueue.addToQueue();

				} finally {

				}
			}
		}

		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		cars.draw(g2, xaxis, yaxis);
	}
}