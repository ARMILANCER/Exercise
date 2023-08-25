package V0;
import Initialization.MatrixInitialization;
import java.util.Vector;

public class MyThread extends Thread{
	private Vector<Integer> matrix;
	private Integer rowSum =0;
	private GlobalSum sum;
	
	public MyThread(Vector<Integer> matrix, GlobalSum sum) {
		this.matrix = matrix;
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for(int i=0;i<matrix.size();i++)
			rowSum += matrix.get(i);
		sum.addValue(rowSum);
	}
	public static void main(String [] args) throws InterruptedException {
		Vector<Vector<Integer>> matrix;
		GlobalSum sum = new GlobalSum();
		
		
		
		matrix = new MatrixInitialization().initialMatrix();
		matrix.forEach(e ->{
			new MyThread(e, sum).start();
		});
		System.out.println("Sum: "+ sum.getValue());
	}
}
