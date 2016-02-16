import java.util.Arrays;

public class NumberTheory {

	int N = 10;

	// make table of prime.
	boolean[] isPrime;
	void makePrime() {
		isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= N; i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = i * 2; j <= N; j += i) {
				isPrime[j] = false;
			}
		}
	}

	// one number prime judge.
	boolean isPrime(int n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// make permutation (N<=11)
	boolean[] used;
	int[] perm;
	void permutation(int pos) {
		if (pos == N) {
			// process
		}
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				perm[pos] = i;
				used[i] = true;
				permutation(pos + 1);
				used[i] = false;
			}
		}
	}

	long modPow(int a, int p, int mod) {
		long base = a;
		long ret = 1;
		while (p > 0) {
			if ((p & 1) == 1) {
				ret = (ret * base) % mod;
			}
			base = (base * base) % mod;
			p >>= 1;
		}
		return ret;
	}

	long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	void fraction(long numerator1, long denominator1, long numerator2, long denominator2) {
		long lcm = lcm(denominator1, denominator2);
		numerator1 *= lcm / denominator1;
		numerator2 *= lcm / denominator2;
		long resNume = numerator1 + numerator2;
		long resDeno = lcm;
		long gcd = gcd(resNume, resDeno);
		System.out.println(resNume / gcd + " / " + resDeno / gcd);
	}

	long combination(long n, long m) {
		m = Math.min(m, n - m);
		long res = 1;
		for (long i = n - m + 1, j = 1; j <= m; i++, j++) {
			res *= i;
			res /= j;
		}
		return res;
	}

	void pascal() {
		int[][] com = new int[1001][1001];
		com[0][0] = 1;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j <= 1000; j++) {
				if (j == 0 || j == i) com[i][j] = 1;
				else com[i][j] = (com[i - 1][j - 1] + com[i - 1][j]) % MOD;
			}
		}
	}

	public static void main(String[] args) {
	}
}

