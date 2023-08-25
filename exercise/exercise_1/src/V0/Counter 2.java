package exercise_1;

public class Counter {
	// 
	private int counter = 0;

	public synchronized int getCounter() {
		return counter;
	}

	public synchronized void setCounter(int counter) {
		this.counter = counter;
	}
	
	public synchronized void increase() {
		counter++;
	}
	
	public synchronized void decrement() {
		counter--;
	}
	
	
}
