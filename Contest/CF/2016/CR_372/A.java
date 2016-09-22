import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] t = new int[n + 1];
		for (int i = 1; i <= n; i++) t[i] = sc.nextInt();
		int s = 0;
		for (int i = 1; i <= n; i++) {
			if (t[i] - t[i - 1] <= c) s++;
			else  s = 1;
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
