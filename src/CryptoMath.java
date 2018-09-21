/**
 * Additional math for cryptology and stats
 * @author jake
 *
 */
public class CryptoMath {
	/**
	 * calculates the factorial of a number
	 * @param x a number
	 * @return factorial of x (x!)
	 */
	public static int factorial(int x) {
		int fact = x;
		while(x != 0) {
			fact *= x;
			x--;
		}
		return fact;
	}
	/**
	 * calculates the combination
	 * @param n smaller number
	 * @param k larger number
	 * @return combination
	 */
	public static double combination(double n, double k) {
		double 
			top = factorial((int) n),
			bottom = factorial((int)k) * factorial((int)(n-k));
		return top / bottom;
	}
	/**
	 * calculates the combination
	 * @param n smaller number
	 * @param k larger number
	 * @return combination
	 */
	public static int combination(int n, int k) {
		int 
			top = factorial(n),
			bottom = factorial(k) * factorial((n-k));
		return top / bottom;
	}
	/**
	 * calculates the combination
	 * @param n smaller number
	 * @param k larger number
	 * @return combination
	 */
	public static float combination(float n, float k) {
		float 
			top = factorial((int)n),
			bottom = factorial((int)k) * factorial((int)(n-k));
		return top / bottom;
	}
	/**
	 * calculates the permutation
	 * @param n smaller number
	 * @param k larger number
	 * @return combination
	 */
	public static double permutation(double n, double k) {
		double
			top = factorial((int)n),
			bottom = factorial((int)(n-k));
		return top / bottom;
	}
	/**
	 * calculates the permutation
	 * @param n smaller number
	 * @param k larger number
	 * @return combination
	 */
	public static int permutation(int n, int k) {
		int
			top = factorial(n),
			bottom = factorial((n-k));
		return top / bottom;
	}
	/**
	 * calculates the permutation
	 * @param n smaller number
	 * @param k larger number
	 * @return combination
	 */
	public static float permutation(float n, float k) {
		float
			top = factorial((int)n),
			bottom = factorial((int)(n-k));
		return top / bottom;
	}
}
