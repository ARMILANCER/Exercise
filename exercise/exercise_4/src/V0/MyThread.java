package V0;
public class MyThread implements Runnable{
	private int cont=0;
	@Override
	public void run(){
		while(cont != 10) {
			try {
				cont++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String [] args) throws InterruptedException {
		int cont=0;
		Thread mySon = new Thread(new MyThread());
		System.out.println("My son is started his activity");
		mySon.start();
		while(mySon.isAlive()) {
			System.out.println("My son incremented his counter, and now Sleeeep");
			System.out.println("control number: "+ ++cont);
			Thread.sleep(500);	
		}
		System.out.println("Oh no, my son is DEAD!!!");
		System.out.println("My life no longer makes sense,");
		System.out.println("Garbage collector, I'm ready.");
		System.out.println("Finish");
	}
}