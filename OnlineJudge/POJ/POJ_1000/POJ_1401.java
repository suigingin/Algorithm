import java.util.Scanner;

public class POJ_1401 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int cnt = 0;
			while (N != 0) cnt += N /= 5;
			System.out.println(cnt);
		}
	}

	public static void main(String[] args) {
		new POJ_1401().run();
	}
}
