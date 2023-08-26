package V0;

import java.util.concurrent.atomic.AtomicInteger;

public class Louvre {
	private final int maxAccess = 5;
	private boolean block = false;
	private AtomicInteger decrementer = new AtomicInteger(maxAccess); 
	
	// if number of access = 0,block and wait the other Thread
	public synchronized void getSource(){
		while(block) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		decrementer.decrementAndGet();
		if(decrementer.get() == 0) {
			block = true;
		}
	}
	public synchronized void releace() {
		decrementer.incrementAndGet();
		block = false;
		System.out.println("Decrement: "+decrementer);
		notify();
	}
}