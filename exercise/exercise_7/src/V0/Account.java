package V0;
import java.util.concurrent.CountDownLatch;
public class Account{
	private CountDownLatch latch;
	private boolean free = true;
	private boolean red = true;
	private int balance = 0;
	
	public synchronized void getSourse() throws InterruptedException {
		while(!free)
			wait();
		free = false;
	}
	
	public synchronized void setBalance(int payment){
		if(payment > 0) {
			balance = payment;
			red = !red;
			latch = new CountDownLatch(1);
			notify();
		}
	}
	public synchronized boolean withdrawal(int amount) {
		if(!red) {
			if(amount > 0 && amount <= balance && (balance - amount) >= 0) {
				balance -= amount;
				if(balance == 0||balance<=10) {
					balance = 0;
					red = true;
				}
			}else return false;
		} else return false;
		return true;
	}
	public synchronized int getBalance() {
		return balance;
	}
	
	public CountDownLatch getLatch() {
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
