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
			out(perm);
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

	public static void main(String[] args) {
	}

	void out(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}

