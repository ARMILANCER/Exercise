package V1;

import java.io.*;
public class MyThreadSum extends Thread{
	private static Variable variable = new Variable();
	private static int n1,n2;
	@Override
	public void run() {
		variable.setSomma(n1+n2);
	}
	public static void main(String [] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		MyThreadSum sum = new MyThreadSum();
		
		System.out.print("Firts Number: ");
		n1 = Integer.parseInt(buff.readLine());
		System.out.print("Seconf Number: ");
		n2 = Integer.parseInt(buff.readLine());
		
		sum.start();
		sum.join();
		
		System.out.print("Result: "+variable.getSomma());
	}
}
