package V0;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
public class TouristThread extends Thread{
	private CountDownLatch latch = new CountDownLatch(1);
	private Louvre louvre;
	private int token = 0;
	public TouristThread(Louvre louvre, int token) {
		this.louvre = louvre;
		this.token = token;
	}
	@Override
	public void run() {
		try {
			access();
		}catch(InterruptedException e) {
		}
	}
	public void access() throws InterruptedException {			
			louvre.getSource();
			System.out.println("I " +token+ "go");
			Thread.sleep(new Random().nextInt(3,5)*1000);
			System.out.println("I " +token+ " finish");
			louvre.releace();
		
	}
	public static void main(String[] args) {
		Louvre louvre = new Louvre();	
		for(int i=0;i<50;i++) {
			new TouristThread(louvre,i+1).start();
		}
	}
}
