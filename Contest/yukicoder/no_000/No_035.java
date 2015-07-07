import java.util.Scanner;

public class No_035 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int y = 0;
		int n = 0;
		while (N-- > 0) {
			double T = sc.nextDouble();
			double d = 12 * T / 1000;
			int L = sc.next().length();
			if (d >= L) {
				y += L;
			} else {
				y += (int) d;
				n += L - (int) d;
			}
		}
		System.out.println(y + " " + n);

	}

	public static void main(String[] args) {
		new No_035().run();
	}
}
