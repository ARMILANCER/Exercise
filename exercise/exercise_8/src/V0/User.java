package V0;

import java.util.Random;

public class User extends Thread{
	CokeMachine cokeMachine; 
	
	public User(CokeMachine cokeMachine) {
		this.cokeMachine = cokeMachine;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				getCola();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void getCola() throws InterruptedException {
		synchronized(cokeMachine){
			cokeMachine.getSourse();
			int i = new Random().nextInt(1,5);
			if(cokeMachine.remove(/*new Random().nextInt(1,5)*/i)){
				System.out.println("remained: "+cokeMachine.remained()+" took: "+i);
			}
			cokeMachine.releaseSourse();
		}
	}
	
	public static void main(String [] args) {
		CokeMachine cokeMachine = new CokeMachine();
		int i=new Random().nextInt(6,12); 
		cokeMachine.deposit(50);
		while(i>0) {
			new User( cokeMachine ).start();
			i--;
		}
		new Supplier(cokeMachine).start();
	}
}
