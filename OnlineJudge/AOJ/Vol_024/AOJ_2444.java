import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AOJ_2444 {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unused")
	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		String s = sc.next();
		Set<Long> set1 = new HashSet<>();
		Set<Long> set2 = new HashSet<>();
		
		RollingHash rh = new RollingHash();
		rh.init(s);
		rh.r = 0;

		int cnt = 0;
		while (m-- > 0) {
			String q = sc.next();
			if (q.charAt(0) == 'R') {
				if (q.charAt(1) == '+') rh.r++;
				else rh.r--;
			} else {
				if (q.charAt(1) == '+') rh.l++;
				else rh.l--;
			}
			long hash1 = rh.getHash1();
			long hash2 = rh.getHash2();
			if(!set1.contains(hash1) || !set2.contains(hash2)) cnt++;
			set1.add(hash1);
			set2.add(hash2);
		}
		System.out.println(cnt);
	}
	
	public class RollingHash {

		String S;
		int N, l, r;

		long B1 = 1007;
		long B2 = 1009;
		long H1 = 1000000007;
		long H2 = 1000000009;

		long[] Base1, Base2;
		long[] Hash1, Hash2;

		void init(String s) {
			S = s;
			N = s.length();
			l = 0;
			r = s.length() - 1;
			Base1 = new long[N + 1];
			Base2 = new long[N + 1];
			Hash1 = new long[N];
			Hash2 = new long[N];

			Base1[0] = Base2[0] = 1;
			Hash1[0] = Hash2[0] = s.charAt(0);
			for (int i = 1; i <= N; i++) Base1[i] = (Base1[i - 1] * B1) % H1;
			for (int i = 1; i <= N; i++) Base2[i] = (Base2[i - 1] * B2) % H2;
			for (int i = 1; i < N; i++) Hash1[i] = (Hash1[i - 1] * B1 + s.charAt(i)) % H1;
			for (int i = 1; i < N; i++) Hash2[i] = (Hash2[i - 1] * B2 + s.charAt(i)) % H2;
		}

		long getHash1() {
			long res = Hash1[r] - ((l == 0) ? 0 : Hash1[l - 1] * Base1[r - l + 1]);
			if (res < 0) res = (res + ((-res / H1) + 1) * H1) % H1;
			return res;
		}

		long getHash2() {
			long res = Hash2[r] - ((l == 0) ? 0 : Hash2[l - 1] * Base2[r - l + 1]);
			if (res < 0) res = (res + ((-res / H2) + 1) * H2) % H2;
			return res;
		}
	}

	public static void main(String[] args) {
		new AOJ_2444().run();
	}
}
