
import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	long B1 = 1007;
	long B2 = 1009;
	long H1 = 1000000007;
	long H2 = 1000000009;

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] s = new String[n];
		long[] nh1 = new long[n];
		long[] nh2 = new long[n];
		for (int i = 0; i < n; i++) s[i] = sc.next();
		for (int i = 0; i < n; i++) {
			long sh1 = 0;
			long sh2 = 0;
			for (int j = 0; j < s[i].length(); j++) {
				sh1 = (sh1 * B1 + (s[i].charAt(j))) % H1;
				sh2 = (sh2 * B2 + (s[i].charAt(j))) % H2;
			}
			nh1[i] = sh1;
			nh2[i] = sh2;
		}
		Arrays.sort(nh1);
		Arrays.sort(nh2);
		StringBuilder out = new StringBuilder();
		while (m-- > 0) {
			String t = sc.next();
			long th1 = 0;
			long th2 = 0;
			for (int j = 0; j < t.length(); j++) {
				th1 = (th1 * B1 + (t.charAt(j))) % H1;
				th2 = (th2 * B2 + (t.charAt(j))) % H2;
			}
			boolean ok = false;
			long b1 = 1;
			long b2 = 1;
			L: for (int j = t.length() - 1; j >= 0; j--) {
				long sub1 = (t.charAt(j) * b1) % H1;
				long sub2 = (t.charAt(j) * b2) % H2;
				th1 = (th1 - sub1 + H1) % H1;
				th2 = (th2 - sub2 + H2) % H2;
				for (char c = 'a'; c <= 'c'; c++) {
					if (t.charAt(j) == c) continue;
					int res1 = Arrays.binarySearch(nh1, (th1 + c * b1) % H1);
					int res2 = Arrays.binarySearch(nh2, (th2 + c * b2) % H2);
					if (res1 >= 0 && res2 >= 0) {
						ok = true;
						break L;
					}
				}
				th1 = (th1 + sub1) % H1; b1 = (b1 * B1) % H1;
				th2 = (th2 + sub2) % H2; b2 = (b2 * B2) % H2;
			}
			out.append(ok ? "YES\n" : "NO\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
