import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int cnt = Integer.MAX_VALUE;

		int b = 0;
		int r = 0;
		// brbr...
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0 && c[i] == 'r') r++;
			else if (i % 2 == 1 && c[i] == 'b') b++;
		}
		cnt = Math.min(cnt, Math.min(b, r) + (Math.max(b, r) - Math.min(b, r)));

		b = r = 0;
		// rbrb...
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0 && c[i] == 'b') b++;
			else if (i % 2 == 1 && c[i] == 'r') r++;
		}
		cnt = Math.min(cnt, Math.min(b, r) + (Math.max(b, r) - Math.min(b, r)));
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
