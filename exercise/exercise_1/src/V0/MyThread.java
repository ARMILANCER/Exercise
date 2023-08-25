package V0;

public class MyThread extends Thread{
	private Counter counter;
	private String symbol;
	
	public MyThread(String symbolC, Counter counterC) {
		counter = counterC;
		symbol = symbolC;
	}
	
	@Override
	public void run(){
		while(true) {
			try {
				counter.getSourse();
				if(counter.increace()) {
					System.out.println(symbol+"("+counter.getCounter()+")");
				}else {
					System.out.print(symbol+"("+counter.getCounter()+")");
				}
				sleep(300);
				counter.releaseSourse();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String [] args) {
		Counter counter = new Counter();
		
		new MyThread("*",counter).start();
		new MyThread("#",counter).start();
//		new MyThread("+",counter).start();
//		new MyThread("-",counter).start();
//		new MyThread("&",counter).start();
//		new MyThread("!",counter).start();
		
	
		

	}
}
