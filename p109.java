/* 
 * Solution to Project Euler problem 109
 * By Nayuki Minase
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class p109 {
	
	private static List<Integer> points;
	private static List<Integer> doublePoints;
	
	static {
		points = new ArrayList<Integer>();  // Orderless, but duplicates are important
		for (int i = 1; i <= 20; i++) {
			points.add(i * 1);
			points.add(i * 2);
			points.add(i * 3);
		}
		points.add(25);
		points.add(50);
		
		doublePoints = new ArrayList<Integer>();  // Orderless, but duplicates are important
		for (int i = 1; i <= 20; i++)
			doublePoints.add(i * 2);
		doublePoints.add(25 * 2);
	}
	
	
	public static void main(String[] args) {
		int checkouts = 0;
		for (int remainingPoints = 1; remainingPoints < 100; remainingPoints++) {
			for (int throwz = 0; throwz <= 2; throwz++) {
				for (int p : doublePoints) {
					if (p <= remainingPoints)
						checkouts += ways(throwz, remainingPoints - p, points.size() - 1);
				}
			}
		}
		System.out.println(checkouts);
	}
	
	
	private static int[][][] ways;
	
	static {
		ways = new int[3][101][points.size()];
		for (int[][] x : ways) {
			for (int[] y : x)
				Arrays.fill(y, -1);
		}
	}
	
	// Number of ways to get exactly 'total' points in exactly 'throwz' throws, using
	// items (unordered) from the 'points' list with index less than or equal to 'maxIndex'.
	private static int ways(int throwz, int total, int maxIndex) {
		if (ways[throwz][total][maxIndex] == -1) {
			int result;
			if (throwz == 0)
				result = total == 0 ? 1 : 0;
			else {
				result = 0;
				if (maxIndex > 0)
					result += ways(throwz, total, maxIndex - 1);
				if (points.get(maxIndex) <= total)
					result += ways(throwz - 1, total - points.get(maxIndex), maxIndex);
			}
			ways[throwz][total][maxIndex] = result;
		}
		return ways[throwz][total][maxIndex];
	}
	
}
