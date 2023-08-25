package Initialization;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MatrixInitialization {
	private static Vector<Vector<Integer>> matrix = new Vector<>();
	private Random rand = new Random();
	private int i = rand.nextInt(1,10), j;
	public Vector<Vector<Integer>> initialMatrix() {
		while(i>=0) {
			matrix.add(new Vector<Integer>());
			j = rand.nextInt(1,10);
			while(j>=0) {
				matrix.lastElement().add(rand.nextInt(10));
				j--;
			}
			i--;
		}
		return matrix;
	}
}
