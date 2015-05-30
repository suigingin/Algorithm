import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		long n = sc.nextLong();
		int cnt = 0;
		for (long h = 1;; h++) {
			long min = h * (3 * h + 1) / 2;
			if (n < min) break;
			if ((n - min) % 3 == 0) cnt++;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
