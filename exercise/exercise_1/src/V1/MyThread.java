package V1;
public class MyThread extends Thread{
	String symbol;
	Counter counter;
	public MyThread(String symbolC, Counter counterC) {
		counter = counterC;
		symbol = symbolC;
	}
	public void run() {
		while(true){
			try {
				counter.getResource().acquire();
				if(counter.increase() % 50 == 0) {
					System.out.println(symbol+"("+counter.getCounter()+")");
				}else {
					System.out.print(symbol+"("+counter.getCounter()+")");
				}
				counter.getResource().release();
				sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Counter counter = new Counter();
		new MyThread("*",counter).start();
		new MyThread("#",counter).start();
	}
}