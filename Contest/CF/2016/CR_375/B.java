import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int res1 = 0;
		int res2 = 0;
		for (int i = 0; i < n; i++) {
			String s = "";
			if (c[i] == '(') {
				while (c[i + 1] != ')') s += c[++i];
				res2 += getStringRes(s, 0);
				i++;
			} else {
				while (i < n && c[i] != '(') s += c[i++];
				res1 = Math.max(res1, getStringRes(s, 1));
				i--;
			}
		}
		System.out.println(res1 + " " + res2);
	}

	int getStringRes(String c, int f) {
		int res = 0;
		String[] s = String.valueOf(c).split("_");
		if (f == 0) {
			for (int i = 0; i < s.length; i++) {
				if (s[i].length() > 0)
					res++;
			}
		} else {
			for (int i = 0; i < s.length; i++) {
				res = Math.max(res, s[i].length());
			}
		}
		return res;
	}

	public static void main(String[] args) {
		new B().run();
	}
}
