import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		int left = 0;
		int revLeft = 0;
		int m = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') left++;
			if (s.charAt(i) == ')') left--;
			if (s.charAt(i) == '#') m++;
			if (left < 0) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = s.length() - 1; s.charAt(i) != '#'; i--) {
			if (s.charAt(i) == '(') revLeft++;
			if (s.charAt(i) == ')') revLeft--;
			if (revLeft > 0) {
				System.out.println(-1);
				return;
			}
		}

		if (left <= 0 || m > left) {
			System.out.println(-1);
		} else {
			left = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') left++;
				if (s.charAt(i) == ')') left--;
				if (s.charAt(i) == '#') {
					if (left <= 0) {
						System.out.println(-1);
						return;
					}
					if (m == 1) {
						int remL = 0;
						for (int j = i; j < s.length(); j++) {
							if (s.charAt(j) == '(') remL++;
							if (s.charAt(j) == ')') remL--;
						}
						if (remL > 0) {
							System.out.println(-1);
							return;
						}
						sb.append(left - (-remL) + "\n");
					} else {
						sb.append(1 + "\n");
					}
					left--;
					m--;
				}
			}
			System.out.print(sb);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
