package exercise_1;

public class MyThread extends Thread {
	private String symbol;
	private Counter counter;
	
	public MyThread(String symbolC, Counter counterC) {
		symbol = symbolC;
		counter = counterC;
	}
	
	@Override
	public void run(){
		while(true) {
			if(counter.getCounter() % 5 == 0 && counter.getCounter() != 0) {
				System.out.print(counter.getCounter());
				counter.setCounter();
				System.out.println();
				
				
			}else{
				System.out.print(counter.getCounter());
				counter.increase();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		MyThread t1 = new MyThread("*",counter);
		MyThread t2 = new MyThread("#",counter);
		
		t1.start();
		t2.start();
	}
}
