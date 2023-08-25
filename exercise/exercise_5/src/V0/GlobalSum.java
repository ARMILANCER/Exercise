package V0;

public class GlobalSum {
	private static Integer sum = 0;
	public static void addValue(Integer value) {
		sum += value;
	}
	public static Integer getValue() {
		return sum;
	}
	
}
