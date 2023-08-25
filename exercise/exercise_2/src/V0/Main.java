package V0;

import java.util.Scanner;

public class Main {
	private static int sum=0; 
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in); 
		int n1;
		System.out.print("Firts number: ");
		sum = scanner.nextInt();
		System.out.print("Second number: ");
		n1 = scanner.nextInt();
		
		Thread sumThread = new Thread(()->{
			sum += n1;
		});
		sumThread.start();
		sumThread.join();
		System.out.print("Sum result: "+sum);
	}
}
