package V1;
import V1.MyThread;
public class MyThread extends Thread{
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override 
	public void run() {
			System.out.println(name);
	}
	public static void main(String[] args) {
			System.out.println(currentThread().getName());
			new MyThread("Pippo").start();
			new MyThread("Ciao").start();
	}
}