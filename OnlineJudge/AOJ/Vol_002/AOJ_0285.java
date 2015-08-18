import java.util.Scanner;

public class AOJ_0285 {
	Scanner sc = new Scanner(System.in);
	int j, y;

	void run() {
		j = sc.nextInt();
		y = sc.nextInt();
		dfs(0, 0, "");
	}

	void dfs(int jcnt, int ycnt, String s) {
		if ((jcnt >= 5 && ycnt <= 3) || (jcnt <= 3 && ycnt >= 5)) {
			if (jcnt == j && ycnt == y) {
				System.out.println(s);
			}
			return;
		}
		if (jcnt == j && ycnt == y) {
			System.out.println(s);
			return;
		}

		if (jcnt != j) dfs(jcnt + 1, ycnt, s + "A");
		if (ycnt != y) dfs(jcnt, ycnt + 1, s + "B");
	}

	public static void main(String[] args) {
		new AOJ_0285().run();
	}
}
