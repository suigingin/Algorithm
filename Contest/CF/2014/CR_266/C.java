import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long[] sum = new long[n];
		sum[0] = sc.nextLong();
		for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + sc.nextLong();
		long div = sum[n - 1] / 3;
		long phase1 = 0;
		long phase2 = 0;
		if (n >= 3 && sum[n - 1] % 3 == 0) {
			for (int i = 0; i < n - 1; i++) {
				if (sum[i] == div * 2) phase2 += phase1;
				if (sum[i] == div) phase1++;
			}
		}
		System.out.println(phase2);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
