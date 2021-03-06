/* 
 * Solution to Project Euler problem 34
 * By Nayuki Minase
 */


public class p034 {
	
	public static void main(String[] args) {
		// As stated in the problem, 1 = 1! and 2 = 2! are excluded.
		// If a number has at least n >= 8 digits, then even if every digit is 9,
		// n * 9! is still less than the number (which is at least 10^n).
		int sum = 0;
		for (int i = 3; i < 10000000; i++) {
			if (i == factorialDigitSum(i))
				sum += i;
		}
		System.out.println(sum);
	}
	
	
	private static int factorialDigitSum(int x) {
		int sum = 0;
		while (x != 0) {
			sum += factorial(x % 10);
			x /= 10;
		}
		return sum;
	}
	
	
	private static int factorial(int n) {
		int prod = 1;
		for (int i = 1; i <= n; i++)
			prod *= i;
		return prod;
	}
	
}
