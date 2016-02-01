import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long p = sc.nextLong();
		long[] l = new long[n];
		long[] r = new long[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextLong();
			r[i] = sc.nextLong();
		}
		double res = 0;
		for (int i = 0; i < n; i++) {
			int a = i % n;
			int b = (i + 1) % n;
			long primeCntA = r[a] / p - (l[a] - 1) / p;
			long primeCntB = r[b] / p - (l[b] - 1) / p;
			long rangeA = r[a] - l[a] + 1;
			long rangeB = r[b] - l[b] + 1;
			res += (1.0 * primeCntA * rangeB + (rangeA - primeCntA) * primeCntB) / (rangeA * rangeB);
		}
		System.out.println(res * 2000);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
