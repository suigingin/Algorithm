import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int[] d = new int[n];
		for (int i = 0; i < n; i++) d[i] = sc.nextInt();
		boolean[] v = new boolean[n];
		int now = 0;
		while (true) {
			if (now < 0 || now >= n) {
				System.out.println("FINITE");
				return;
			}
			if (v[now]) {
				System.out.println("INFINITE");
				return;
			}
			v[now] = true;
			now += c[now] == '>' ? d[now] : -d[now];
		}
	}

	public static void main(String[] args) {
		new B().run();
	}
}
