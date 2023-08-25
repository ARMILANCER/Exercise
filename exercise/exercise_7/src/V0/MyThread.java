package V0;
import java.util.Random;
public class MyThread extends Thread{
	private Account account;
	private int amount = 0;
	
	public MyThread(Account account) {
		this.account = account;
	}
	
	@Override 
	public void run() {
		while(true) {
			try {
				amount = new Random().nextInt(0,100);
				tryGetSourse();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void tryGetSourse() throws InterruptedException {
		synchronized(account) {
			account.getSourse();
			if(account.withdrawal(amount)){
				System.out.println("Amount: "+amount+" Balance: "+account.getBalance());
			}//else System.out.println("Operation not performed");
			account.releaseSourse();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int i = new Random().nextInt(6,12);
		Account account = new Account();
		account.setBalance(1000);
		while(i>0) {
			new MyThread(account).start();
			i--;
		}
		while(true) {
			account.getLatch().await();
			account.setBalance(1000);
		}
		
	}
}