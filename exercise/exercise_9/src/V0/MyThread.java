package V0;
import java.util.concurrent.*;
public class MyThread extends Thread{
	@Override
	public void run(){
		long startTime = System.currentTimeMillis();
		try {
			System.out.println("Sleep Thread");
			sleep(10000);
		}catch(InterruptedException e) {
			long currentTime = System.currentTimeMillis() - startTime;
			 System.out.println("Time in Sleep: "+ currentTime/1000);
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		
		myThread.start();
		try{
			sleep(5000);
			myThread.interrupt();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
