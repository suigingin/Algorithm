import java.util.Scanner;

public class No_032 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int L = sc.nextInt();
		int M = sc.nextInt();
		int N = sc.nextInt();

		int coin = 0;
		M += N / 25;
		coin += N % 25;
		L += M / 4;
		coin += M % 4;
		coin += L % 10;
		System.out.println(coin);
	}

	public static void main(String[] args) {
		new No_032().run();
	}
}
