import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int max = 1;
		int seq = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] >= a[i - 1]) seq++;
			else seq = 1;
			max = Math.max(max, seq);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
