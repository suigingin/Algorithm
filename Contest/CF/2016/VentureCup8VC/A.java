import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		String s = sc.next();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				String d = s.substring(i, j + 1);
				int x = 0;
				int y = 0;
				for (int k = 0; k < d.length(); k++) {
					if (d.charAt(k) == 'U') y++;
					else if (d.charAt(k) == 'D') y--;
					else if (d.charAt(k) == 'R') x++;
					else x--;
				}
				if (y == 0 && x == 0) cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
