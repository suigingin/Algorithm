import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res1 = Math.min(a, b);
		a -= res1;
		b -= res1;
		int res2 = Math.max(a, b) / 2;
		System.out.println(res1 + " " + res2);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
