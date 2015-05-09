import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int k = sc.nextInt();
		String q = sc.next();
		int[] cnt = new int[26];
		for (int i = 0; i < q.length(); i++) cnt[q.charAt(i) - 'a']++;
		int diff = 0;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] != 0) diff++;
		}
		StringBuilder out = new StringBuilder();
		if (diff < k) {
			out.append("NO\n");
		} else {
			out.append("YES\n");
			for (int i = 0; i < q.length();) {
				cnt[q.charAt(i) - 'a'] = 0;
				while (i < q.length() && (cnt[q.charAt(i) - 'a'] == 0 || k == 1)) {
					out.append(q.charAt(i++));
				}
				k--;
				out.append("\n");
			}
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
