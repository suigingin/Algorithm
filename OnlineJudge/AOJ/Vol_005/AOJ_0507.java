import java.util.Scanner;

public class AOJ_0507 {
	Scanner sc = new Scanner(System.in);
	StringBuilder sb;

	void run() {
		for (;;) {
			int n = sc.nextInt();
			if (n == 0) return;
			sb = new StringBuilder();
			dfs(n, n, "");
			System.out.print(sb);
		}
	}

	void dfs(int pre, int rem, String s) {
		if (rem == 0) {
			sb.append(s + "\n");
			return;
		}

		for (int use = rem; use >= 1; use--) {
			if (use <= pre) {
				dfs(use, rem - use, (s.length() == 0) ? use + "" : s + " " + use);
			}
		}
	}

	public static void main(String[] args) {
		new AOJ_0507().run();
	}
}
