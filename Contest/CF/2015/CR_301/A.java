import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String from = sc.next();
		String to = sc.next();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int f = from.charAt(i) - '0';
			int t = to.charAt(i) - '0';
			cnt += Math.min(Math.abs(f - t), 10 - Math.abs(f - t));
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
