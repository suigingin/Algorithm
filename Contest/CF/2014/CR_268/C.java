import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		if (n <= 3) {
			System.out.println("NO");
			return;
		}

		StringBuilder out = new StringBuilder();
		out.append("YES\n");
		int cnt = (n - 4) / 2;
		if (n % 2 == 0) {
			for (int i = 5; i <= n; i += 2) out.append(i + 1 + " - " + i + " = 1\n");
			for (int i = 0; i < cnt; i++)   out.append("1 * 1 = 1\n");
			out.append("1 * 4 = 4\n");
			out.append("4 * 3 = 12\n");
			out.append("12 * 2 = 24\n");
		} else {
			for (int i = 6; i <= n; i += 2) out.append(i + 1 + " - " + i + " = 1\n");
			for (int i = 0; i < cnt; i++)   out.append("1 * 1 = 1\n");
			out.append("1 + 2 = 3\n");
			out.append("5 - 3 = 2\n");
			out.append("4 * 3 = 12\n");
			out.append("12 * 2 = 24\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
