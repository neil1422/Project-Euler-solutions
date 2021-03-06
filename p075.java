/* 
 * Solution to Project Euler problem 75
 * By Nayuki Minase
 */

import java.util.HashSet;
import java.util.Set;


public class p075 {
	
	public static void main(String[] args) {
		int n = 1500000;
		
		/*
		 * Pythagorean triples theorem:
		 *   Every primitive Pythagorean triple with a odd and b even can be expressed as
		 *   a = st, b = (s^2-t^2)/2, c = (s^2+t^2)/2, where s > t >= 1 are coprime odd integers.
		 */
		Set<IntTriple> triples = new HashSet<IntTriple>();
		for (int t = 1; t * t <= n; t += 2) {
			for (int s = t + 2; s * s <= n; s += 2) {
				if (Library.gcd(s, t) == 1) {
					int a = s * t;
					int b = (s * s - t * t) / 2;
					int c = (s * s + t * t) / 2;
					int sum = a + b + c;
					if (sum <= n)
						triples.add(new IntTriple(a, b, c));
				}
			}
		}
		
		byte[] ways = new byte[n + 1];
		for (IntTriple triple : triples) {
			int sum = triple.a + triple.b + triple.c;
			for (int i = 1; i * sum <= n; i++)
				ways[i * sum] = (byte)Math.min(ways[i * sum] + 1, 2);  // Increment but saturate at 2
		}
		
		int count = 0;
		for (int x : ways) {
			if (x == 1)
				count++;
		}
		System.out.println(count);
	}
	
	
	
	private static class IntTriple {
		
		public final int a;
		public final int b;
		public final int c;
		
		
		public IntTriple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		
		public boolean equals(Object obj) {
			if (!(obj instanceof IntTriple))
				return false;
			else {
				IntTriple other = (IntTriple)obj;
				return a == other.a && b == other.b && c == other.c;
			}
		}
		
		public int hashCode() {
			return a + b + c;
		}
		
	}
	
}
