import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int cnt = 0;
		while (n-- > 0) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			if (q - p >= 2) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
