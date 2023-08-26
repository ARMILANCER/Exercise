package V0;
import java.util.*;
public class TouristThread extends Thread{
	private Louvre louvre;
	
	public TouristThread(Louvre louvre) {
		this.louvre = louvre;

	}
	
	@Override
	public void run() {
		try {
			access();
		}catch(InterruptedException e) {
		}
	}
	public void access() throws InterruptedException {
		Thread.sleep(new Random().nextInt(100));
		
		synchronized(louvre) {
			louvre.getSource();
		}
		
		// simulate time spent indoors
		int time = new Random().nextInt(1,4)*1000;
		System.out.println("I "+Thread.currentThread().getId()+"watching "+"for "+time);
		sleep(time);
		
		synchronized(louvre) {
			System.out.println("I "+Thread.currentThread().getId()+" I finished watching");
			louvre.releace();
		}
	}

	public static void main(String[] args) {
		Louvre louvre = new Louvre();
		for(int i=0;i<50;i++) {
			new TouristThread(louvre).start();
		}
	}
}
