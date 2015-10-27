import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[] table = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] s = sc.next().toCharArray();
		for (int i = 0; i < m; i++) {
			char r1 = sc.next().charAt(0);
			char r2 = sc.next().charAt(0);
			swap(table, r1 - 'a', r2 - 'a');
		}
		for (int i = 0; i < n; i++) {
			s[i] = (char) ('a' + String.valueOf(table).indexOf(s[i]));
		}
		System.out.println(String.valueOf(s));
	}

	public static void main(String[] args) {
		new B().run();
	}

	void swap(char[] x, int a, int b) {
		char tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}
}
