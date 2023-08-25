package Counter;
public class Counter {
	private int counter = 0;
	
	public synchronized void increment() throws InterruptedException {
		if(counter<10) {
			counter++;
			
		}
	}
	public synchronized void decrement() throws InterruptedException {
		if(counter>0) {
			counter--;
		}
	}
	public synchronized int getCounter() throws InterruptedException  {
		return counter;
	}
	
	public synchronized void release() throws InterruptedException {
		notify();
		wait();
	}
}
