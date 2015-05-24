import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {

		int k = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		int cost = 0;
		for (int i = 1; i <= w; i++) cost += i * k;
		System.out.println(cost > n ? cost - n : 0);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
