package V0;
import Counter.Counter;
import java.util.Random;
public class MyThread extends Thread{
	// IN initial nature
	private boolean myIN = new Random().nextBoolean();
	private int myName;
	private Counter counter;
	public MyThread(Counter counter,int indice) {
		this.counter = counter;
		myName = indice;
	}
	@Override
	public void run() {
		while(true) {
			synchro();
		}
	}
	public void synchro() {
		synchronized(counter){
			try {
				if(myIN) {
					myIN = !myIN;
					counter.increment();
				}else {
					myIN = !myIN;
					counter.decrement();
					
				}
				System.out.print("Name Thread: "+myName+" ");
				System.out.println("Counter: "+counter.getCounter());
				Thread.sleep(100);
				counter.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String [] args) {
		Counter counter = new Counter();
		int i = new Random().nextInt(6,12);
		while(i>0) {
			new MyThread(counter,i).start();
			i--;
		}
	}
}