import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int q = sc.nextInt();
		char[] s = sc.next().toCharArray();
		int res = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s[i] == '.') {
				cnt++;
				if (i + 1 == n || s[i + 1] != '.') res += cnt - 1;
			} else {
				cnt = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int x = sc.nextInt() - 1;
			char c = sc.next().charAt(0);
			if (c == '.' && s[x] == '.' || c != '.' && s[x] != '.') {
				sb.append(res+"\n");
			} else {
				if (c == '.') {
					if (x + 1 < n && s[x + 1] == '.')  res++;
					if (x - 1 >= 0 && s[x - 1] == '.') res++;
				} else {
					if (x + 1 < n && s[x + 1] == '.')  res--;
					if (x - 1 >= 0 && s[x - 1] == '.') res--;
				}
				sb.append(res+"\n");
			}
			s[x] = c;
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
