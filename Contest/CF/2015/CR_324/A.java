import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int t = sc.nextInt();
		if (n == 1 && t == 10) {
			System.out.println(-1);
			return;
		}
		String res = "";
		if (t < 10) {
			for (int i = 0; i < n; i++) res += t;
		} else {
			for (int i = 0; i < n - 1; i++) res += 1;
			res += 0;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
