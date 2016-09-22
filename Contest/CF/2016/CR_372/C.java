import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (long k = 1; k <= n; k++) {
			if (k == 1) sb.append(2 + "\n");
			else sb.append((k * (k + 1) * (k + 1) - (k - 1)) + "\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
