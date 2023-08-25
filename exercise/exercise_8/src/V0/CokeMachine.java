package V0;

import java.util.concurrent.CountDownLatch;

class CokeMachine {
    private static final int maxTinCans = 50;     
    private CountDownLatch latch;
	private boolean free = true;
	private boolean red = true;
	private int count;
	
	public synchronized void getSourse() throws InterruptedException {
		while(!free)
			wait();
		free = false;
	}
	
	public synchronized void deposit(int TinCans){
		if(TinCans > 0 && TinCans <= maxTinCans) {
			count = TinCans;
			red = !red;
			latch = new CountDownLatch(1);
			notifyAll();
			
		}
	}
	public synchronized boolean remove(int amount) {
		if(!red) {
			if(amount > 0 && amount <= count && (count - amount) >= 0) {
				count -= amount;
				if(count == 0) {
					red = true;
				}
			}else return false;
		} else return false;
		return true;
	}
	public synchronized int remained() {
		return count;
	}
	
	public synchronized CountDownLatch getLatch() {
		return latch;
	}
	public synchronized void releaseSourse()throws InterruptedException {
		free = true;
		while(red) {
			latch.countDown();
			wait();
		}
		Thread.sleep(200);
		notify();
		wait();
	}
}