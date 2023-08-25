package V0;

public class Counter {
	private int counter=0;
	private boolean free = true;

	public synchronized int getCounter() {
		return counter;
	}	
	public synchronized boolean increace(){
		counter++;
		return autoGestion();
	}
	public synchronized boolean autoGestion() {
		if(counter == 50) {
			counter=0;
		return true;
		}
		return false;
	}
	public synchronized void getSourse() throws InterruptedException {
		while(!free)
			wait();
		free = false;
	}
	public synchronized void releaseSourse()throws InterruptedException {
		free = true;
		notify();
		wait();
	}
}
