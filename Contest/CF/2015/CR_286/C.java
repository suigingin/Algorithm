import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	int[] p;
	int[][] v;
	int diff;

	void run() {
		int n = sc.nextInt();
		int d = sc.nextInt();
		v = new int[500][30001];
		p = new int[30001];
		diff = d - 250;
		for (int i = 0; i < 500; i++) Arrays.fill(v[i], -1);
		for (int i = 0; i < n; i++) p[sc.nextInt()]++;
		System.out.println(dfs(d, d));
	}

	int dfs(int jump, int cur) {
		if (cur > 30000) return 0;
		if (v[jump - diff][cur] != -1) return v[jump - diff][cur];
		int res = 0;
		if (jump == 1) {
			res = p[cur] + Math.max(dfs(jump + 1, cur + jump + 1), dfs(jump, cur + jump));
		} else {
			res = p[cur] + Math.max(dfs(jump - 1, cur + jump - 1), Math.max(dfs(jump, cur + jump), dfs(jump + 1, cur + jump + 1)));
		}
		return v[jump - diff][cur] = res;
	}

	public static void main(String[] args) {
		new C().run();
	}
}
