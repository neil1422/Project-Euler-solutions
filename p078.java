/* 
 * Solution to Project Euler problem 78
 * By Nayuki Minase
 */

import java.util.HashMap;
import java.util.Map;


public class p078 {
	
	private static int MODULUS = 1000000;
	
	
	public static void main(String[] args) {
		for (int i = 0; ; i++) {
			if (partition(i) == 0) {
				System.out.println(i);
				break;
			}
		}
		
	}
	
	
	private static Map<Integer,Integer> partitionMemo = new HashMap<Integer,Integer>();
	
	private static int partition(int n) {  // Modulo the modulus
		if (!partitionMemo.containsKey(n)) {
			int result;
			if (n < 0)  // Won't actually invoke this case
				return 0;
			else if (n == 0)
				return 1;
			else {
				/*
				 * Theorem:
				 *   p(n) = 0, if n < 0
				 *   p(0) = 1
				 *   p(n) = ... p(n-15) - p(n-7) + p(n-2) + p(n-1) - p(n-5) + p(n-12) ...
				 *        = sum of (-1)^(i+1) p(n - pent(i)) for i from -inf to inf excluding 0
				 *        when n > 0
				 * The last equation is based on the pentagonal number theorem.
				 * Note: pent(n) = n(3n - 1) / 2
				 */
				result = 0;
				for (int i = 1; ; i++) {
					int temp = pentagon(i);
					if (temp > n)
						break;
					result = (result + (i % 2 == 0 ? -1 : 1) * partition(n - temp) + MODULUS) % MODULUS;
				}
				for (int i = -1; ; i--) {
					int temp = pentagon(i);
					if (temp > n)
						break;
					result = (result + (i % 2 == 0 ? -1 : 1) * partition(n - temp) + MODULUS) % MODULUS;
				}
			}
			partitionMemo.put(n, result);
		}
		return partitionMemo.get(n);
	}
	
	
	private static int pentagon(int n) {
		return n * (n * 3 - 1) / 2;
	}
	
}
