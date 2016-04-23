import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		char[] c = sc.next().toCharArray();
		char[] a = sc.next().toCharArray();
		int k = sc.nextInt();
		int n = c.length;
		int cnt = 0;
		Trie root = new Trie();

		for (int i = 0; i < n; i++) {
			Trie t = root;
			int bad = 0;
			for (int j = i; j < n; j++) {
				if (a[c[j] - 'a'] == '0') bad++;
				if (bad > k) break;
				if (t.child[c[j] - 'a'] == null) {
					t.child[c[j] - 'a'] = new Trie();
					cnt++;
				}
				t = t.child[c[j] - 'a'];
			}
		}
		System.out.println(cnt);
	}

	class Trie {
		Trie[] child;
		public Trie() {
			child = new Trie[26];
		}
	}

	public static void main(String[] args) {
		new D().run();
	}
}
