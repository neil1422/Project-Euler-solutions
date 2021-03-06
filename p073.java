/* 
 * Solution to Project Euler problem 73
 * By Nayuki Minase
 */


public class p073 {
	
	public static void main(String[] args) {
		System.out.println(sternBrocot());  // Probably needs more stack; use something like "-Xss4M" for the JVM
		System.out.println(naive());
	}
	
	
	// Naive method
	
	private static int naive() {
		int count = 0;
		for (int d = 1; d <= 12000; d++) {
			for (int n = 1; n <= d / 2; n++) {
				if (Library.gcd(n, d) == 1 && lessThan(1, 3, n, d) && lessThan(n, d, 1, 2))
					count++;
			}
		}
		return count;
	}
	
	
	private static boolean lessThan(int n0, int d0, int n1, int d1) {
		return n0 * d1 < n1 * d0;
	}
	
	
	// Stern-Brocot tree method
	
	private static int sternBrocot() {
		return count(2, 5, 1, 3, 1, 2);
	}
	
	
	private static int count(int n, int d, int leftN, int leftD, int rightN, int rightD) {
		if (d > 12000)
			return 0;
		else
			return 1 + count(n + leftN, d + leftD, leftN, leftD, n, d) + count(n + rightN, d + rightD, n, d, rightN, rightD);
	}
	
}
