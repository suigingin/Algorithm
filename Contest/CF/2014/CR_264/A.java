import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int s = sc.nextInt();
		int max = -1;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (s > x) {
				max = (y == 0) ? Math.max(max, 0) : Math.max(max, 100 - y);
			} else if (s == x && y == 0) {
				max = Math.max(max, 0);
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
