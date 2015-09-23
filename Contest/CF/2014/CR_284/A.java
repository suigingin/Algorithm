import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int cost = 0;
		int now = 1;
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			while (now + x <= l) now += x;
			cost += r - now + 1;
			now = r + 1;
		}
		System.out.println(cost);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
