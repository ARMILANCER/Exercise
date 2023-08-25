package V1;

import java.util.concurrent.Semaphore;

public class Counter {
	private int counter=0;
	private static Semaphore semaphore = new Semaphore(1); 
	
	public synchronized int increase() {
			counter++;
			return counter;
	}
	public synchronized int getCounter() {
		return counter;
	}
	public Semaphore getResource() throws InterruptedException{
		synchronized(this){
			return semaphore;
		}
	};
}
