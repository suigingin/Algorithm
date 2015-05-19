import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		boolean[] level = new boolean[n];
		int p = sc.nextInt();
		for (int i = 0; i < p; i++) level[sc.nextInt() - 1] = true;
		p = sc.nextInt();
		for (int i = 0; i < p; i++) level[sc.nextInt() - 1] = true;
		for (int i = 0; i < n; i++) {
			if (!level[i]) {
				System.out.println("Oh, my keyboard!");
				return;
			}
		}
		System.out.println("I become the guy.");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
