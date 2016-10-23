import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String[] s = sc.next().split(":");
		int H = Integer.valueOf(s[0]);
		int M = Integer.valueOf(s[1]);
		if (n == 12) {
			if (H > 12) H = (H % 10 == 0) ? 10 : H % 10;
			else if (H == 0) H = 1;
			if (M > 59) M %= 10;
		} else {
			if (H >= 24) H %= 10;
			if (M > 59) M %= 10;
		}
		s[0] = H < 10 ? "0" + H : H + "";
		s[1] = M < 10 ? "0" + M : M + "";
		System.out.println(s[0] + ":" + s[1]);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
