import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] r = new int[m + 1];
		int[] t = new int[m + 1];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int s = 0;
		for (int i = 0; i < m; i++) {
			int ti = sc.nextInt();
			int ri = sc.nextInt();
			while (s > 0 && ri >= r[s - 1]) s--;
			r[s] = ri;
			t[s] = ti;
			s++;
		}
		r[s] = 0;
		int bl = 0;
		int br = r[0];
		for (int i = 0; i < br; i++) b[i] = a[i];
		Arrays.sort(b, 0, br);
		for (int i = 1; i <= s; i++) {
			for (int j = r[i-1]-1; j >= r[i]; j--) {
				a[j] = (t[i - 1] == 1) ? b[--br] : b[bl++];
			}
		}
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < a.length; i++) out.append(a[i] +" ");
		System.out.println(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
