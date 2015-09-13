import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (x % i == 0 && n >= x / i) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
