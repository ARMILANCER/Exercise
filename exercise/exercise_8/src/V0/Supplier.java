package V0;

public class Supplier extends Thread{
	CokeMachine cokeMachine;
	
	public Supplier(CokeMachine cokeMachine) {
		this.cokeMachine = cokeMachine;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				cokeMachine.getLatch().await();
				fillsMachine();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	 
	public void fillsMachine() throws InterruptedException {
		synchronized(cokeMachine){
			cokeMachine.getSourse();
			cokeMachine.deposit(50);
			cokeMachine.releaseSourse();
		}
	}
}