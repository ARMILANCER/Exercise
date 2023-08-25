package V2;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
	private String symbol;
	private static Integer counter;
	private Semaphore semaphore;
	
	public MyThread(String symbol,Integer counter,Semaphore semaphore) {
		this.symbol = symbol;
		MyThread.counter = counter;
		this.semaphore = semaphore;
	}
	public void run() {
		while(true) {
			synchronized(symbol) {
				try{
					semaphore.acquire();
					counter++;
					if(counter % 50 == 0) {
						System.out.println(symbol+"("+counter+")");
					}else {
						System.out.print(symbol+"("+counter+")");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaphore.release();
					try {
	                    Thread.sleep(200);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
				}
			}
		}
	}
	public static void main(String [] args) {
		Integer counter = 0;
		Semaphore semaphore = new Semaphore(1);
		new MyThread("*",counter, semaphore).start();
		new MyThread("#",counter, semaphore).start();
	}
}
