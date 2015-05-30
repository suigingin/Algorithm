import java.util.Arrays;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int M = 1000000;
		boolean prime[] = new boolean[M + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i * i <= M; i++) {
			if (!prime[i]) continue;
			for (int j = i + i; j <= M; j += i) prime[j] = false;
		}
		int n = sc.nextInt();
		for (int i = 4; i <= n; i++) {
			if (!prime[i] && !prime[n - i]) {
				System.out.println(i + " " + (n - i));
				break;
			}
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
