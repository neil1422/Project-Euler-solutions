/* 
 * Solution to Project Euler problem 30
 * By Nayuki Minase
 */


public class p030 {
	
	public static void main(String[] args) {
		// As stated in the problem, 1 = 1^5 is excluded.
		// If a number has at least n >= 7 digits, then even if every digit is 9,
		// n * 9^5 is still less than the number (which is at least 10^n).
		int sum = 0;
		for (int i = 2; i < 1000000; i++) {
			if (i == fifthPowerDigitSum(i))
				sum += i;
		}
		System.out.println(sum);
	}
	
	
	private static int fifthPowerDigitSum(int x) {
		int sum = 0;
		while (x != 0) {
			int y = x % 10;
			sum += y * y * y * y * y;
			x /= 10;
		}
		return sum;
	}
	
}
