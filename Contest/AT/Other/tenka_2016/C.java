import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	class Trie {
		Trie[] child;
		int w;

		public Trie() {
			child = new Trie[26];
			w = 0;
		}
	}

	void run() {
		char[] c = sc.next().toCharArray();
		int N = c.length;
		int M = sc.nextInt();
		String[] p = new String[M];
		int[] w = new int[M];
		for (int i = 0; i < M; i++) p[i] = sc.next();
		for (int i = 0; i < M; i++) w[i] = sc.nextInt();

		// Trie Tree
		Trie root = new Trie();
		for (int i = 0; i < M; i++) {
			Trie t = root;
			for (int j = 0; j < p[i].length(); j++) {
				if (t.child[p[i].charAt(j) - 'a'] == null) {
					t.child[p[i].charAt(j) - 'a'] = new Trie();
				}
				t = t.child[p[i].charAt(j) - 'a'];
			}
			t.w = w[i];
		}

		long[] dp = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			if (i - 1 >= 0) dp[i] = Math.max(dp[i], dp[i - 1]);
			Trie t = root;
			for (int j = i; j - i < 200 && j < N; j++) {
				if (t.child[c[j] - 'a'] != null) {
					dp[j + 1] = Math.max(dp[j + 1], dp[i] + t.child[c[j] - 'a'].w);
				} else {
					break;
				}
				t = t.child[c[j] - 'a'];
			}
		}
		System.out.println(dp[N]);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
