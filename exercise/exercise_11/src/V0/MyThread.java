package V0;

public class MyThread extends Thread{
	Telescope telescope;
	
	public MyThread(Telescope telescope) {
		this.telescope = telescope;
	}
	
	@Override
	public void run() {
		try {
		System.out.println("Waiting for my turn");
		secondState();
		}catch(InterruptedException e ) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("I release the resource");
				telescope.freeSource();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void secondState()throws InterruptedException{
		synchronized(telescope) {
			telescope.getSource();
			
			System.out.println(telescope.observe());
			sleep(3000);
		}
	}
	
	public static void main(String[] args) {
		Telescope telescope = new Telescope();
		for(int i=0;i<10;i++) {
			new MyThread(telescope).start();
		}
	}
}
