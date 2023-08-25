package exercise_10;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;
public class MyThread extends Thread{
	private double obtainedValue = 0.0;
	private CountDownLatch latch = new CountDownLatch(1);
	private boolean myIN = false;
	private boolean cicle = true;
	private int oddNumber = 1;
	private double accuracy = 0.0;
	
	public MyThread(double accuracy) {
		this.accuracy = accuracy;
	}
	
	@Override
	public void run() {
		while(cicle) {
			try {
				if(myIN) {
					obtainedValue -= 4.0/oddNumber;
					myIN = false;
				}else{
					obtainedValue += 4.0/oddNumber;
					myIN = true;
				}
				//System.out.println("4/"+oddNumber+": "+obtainedValue);
				sleep(20);
				oddNumber += 2;
				if((Math.abs(obtainedValue - Math.PI))<accuracy) {
					System.out.println("VERIFICATO");
					latch.countDown();
					cicle = false;
					currentState();
				}
			} catch (InterruptedException e) {
				currentState();
				cicle = false;
			}
			
		}
	}
	
	public void currentState() {
		System.out.println("Pi calc: "+Math.abs(obtainedValue - Math.PI));
		System.out.println("Pi -> 4/"+oddNumber+": "+obtainedValue);
	}
	
	public static void main(String [] args) throws InterruptedException, NumberFormatException, IOException{
		BufferedReader buffR = new BufferedReader(new InputStreamReader(System.in));
		MyThread myThread;
		Timer timer = new Timer();
		
		System.out.println("Waiting time: ");
		int wTime = Integer.parseInt(buffR.readLine());
		System.out.println("Accuracy[0.1 - 0.01 - 0.001]: ");
		double accuracy = Double.parseDouble(buffR.readLine());
		
		myThread = new MyThread(accuracy);
		
		myThread.start();
		
		TimerTask task = new TimerTask(){
			@Override
			public void run() {
				myThread.interrupt();
			}
		};
		timer.schedule(task,wTime*1000);
		
	}
}
