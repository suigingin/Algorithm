import java.util.ArrayList;
import java.util.Arrays;

public class TheKingsFactorization {

	public long[] getVector(long N, long[] primes) {
		long n = N;
		ArrayList<Long> l = new ArrayList<Long>();
		for (long ele : primes) {
			l.add(ele);
			n /= ele;
		}

		for (long i = 2; i * i * i <= N; i++) {
			while (n % i == 0) {
				n /= i;
				l.add(i);
			}
		}

		if (n != 1) l.add(n);

		long[] res = new long[l.size()];
		for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
		Arrays.sort(res);
		return res;
	}
}
