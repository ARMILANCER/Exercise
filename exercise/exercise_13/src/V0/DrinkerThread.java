package V0;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class DrinkerThread extends Thread{
	private static Semaphore semaphore = new Semaphore(3);
	private static int liters = 100;
	private boolean empty = false;
	
	@Override
	public void run() {
		while(!empty) {
			try{
				sleep(new Random().nextInt(1000));
				semaphore.acquire();
				if(liters>0) {
					System.out.println("Remained: "+liters+", Thread "+getId()+" drink");
					liters--;
				}else {
					System.out.println("Thread "+getId()+" found the tank empty.");
					empty = true;
				}
				semaphore.release();
			}catch(InterruptedException e) {
				e.getCause();
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
			new DrinkerThread().start();
		}
	}
}
