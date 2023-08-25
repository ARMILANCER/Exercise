package V0;

public class Telescope {
	private boolean free = true;
	
	public synchronized void getSource()throws InterruptedException {
		while(!free) {
			wait();
		}
		free = false;
	}
	
	public synchronized String observe() {
		return "Now I see you, or ephemeral light, that pierces the presumed perpetual unknown";
	}
	
	public synchronized void freeSource()throws InterruptedException {
		free = true;
		notifyAll();
	}
	
}
