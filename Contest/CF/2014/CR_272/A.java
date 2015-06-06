import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n < m) {
			System.out.println(-1);
			return;
		}

		int min = n % 2 == 0 ? (n / 2) : (n / 2 + 1);
		while (min % m != 0) min++;
		System.out.println(min);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
