import java.util.Arrays;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long[] l = new long[n];
		for (int i = 0; i < n; i++) l[i] = sc.nextLong();
		Arrays.sort(l);
		long sum = 0;
		for (int i = 0; i < n - 1; i++) sum += l[i];
		System.out.println(l[n - 1] - sum + 1);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
