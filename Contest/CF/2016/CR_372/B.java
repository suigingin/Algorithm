import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		char[] s = sc.next().toCharArray();
		int N = s.length;

		if (N < 26) {
			System.out.println(-1);
			return;
		}

		for (int i = 25; i < N; i++) {
			int[] c = new int[26];
			for (int j = 0; j < 26; j++) {
				if (s[i + j - 25] != '?') c[s[i + j - 25] - 'A']++;
			}

			boolean ok = true;
			for (int j = 0; j < 26; j++) if (c[j] > 1) ok = false;

			if (ok) {
				int add = 0;
				for(int j = i - 25; j <= i ; j++) {
					if(s[j] == '?') {
						while(add < 26 && c[add] == 1) add++;
						s[j] = (char)(add++ + 'A');
					}
				}
				for(int j = 0; j < N; j++) if(s[j] == '?') s[j] = 'A';
				System.out.println(String.valueOf(s));
				return;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		new B().run();
	}

}
