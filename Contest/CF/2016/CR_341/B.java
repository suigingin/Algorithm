import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long[] sumA = new long[2020];
		long[] sumB = new long[2020];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sumA[x - y + 1000]++;
			sumB[x + y]++;
		}
		long ans = 0;
		for (int i = 0; i < 2020; i++) {
			if (sumA[i] > 1) ans += sumA[i] * (sumA[i] - 1) / 2;
			if (sumB[i] > 1) ans += sumB[i] * (sumB[i] - 1) / 2;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
