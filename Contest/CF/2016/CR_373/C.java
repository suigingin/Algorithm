import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int t = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int dot = 0;
		for (int i = 0; i < n; i++) {
			if (c[i] == '.') {
				dot = i;
				break;
			}
		}

		int tail = dot;
		for (int i = tail; i < n; i++) {
			if (c[i] >= '5') {
				tail = i;
				break;
			}
		}

		if (tail == dot) {
			System.out.println(String.valueOf(c));
			return;
		}

		int l = tail;
		while (t-- > 0) {
			while (c[tail] != '.' && c[tail] < '5') tail--;
			if (tail == dot) break;

			if (c[tail - 1] == '.') {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < dot; i++) sb.append(c[i]);
				for (int i = sb.length() - 1; i >= 0; i--) {
					if (sb.charAt(i) != '9') {
						sb.setCharAt(i, (char) (sb.charAt(i) + 1));
						break;
					} else {
						sb.setCharAt(i, '0');
					}
					if(i == 0) sb.insert(0, '1');
				}
				System.out.println(sb);
				return;
			} else {
				tail--;
				c[tail]++;
				l = tail;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= l; i++) sb.append(c[i]);
		System.out.println(sb);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
