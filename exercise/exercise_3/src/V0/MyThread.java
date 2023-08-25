package V0;

public class MyThread implements Runnable{
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override 
	public void run() {
		System.out.println(name);
	}
	public static void main(String[] args) {
		
		System.out.println (Thread.currentThread().getName());
		
		Thread runner1 = new Thread(new MyThread("Pippo"));
		Thread runner2 = new Thread(new MyThread("Ciao"));
		new Thread(()->{
			System.out.println("Pippo1");
		}).start();
		new Thread(()->{
			System.out.println("Ciao1");
		}).start();
		
		runner1.start();
		runner2.start();
	}
	
}
