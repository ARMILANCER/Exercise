package V0;

public class Louvre {
	private int maxThreads = 5;
	private boolean block = false;
	
	public synchronized void getSource()throws InterruptedException {
		while(block) {
			wait();
		}
		maxThreads--;
		if(maxThreads == 0) {
			block = true;
		}
	}
	
	public synchronized void releace() {
		notifyAll();
		maxThreads++;
		block= false;
	}
}
