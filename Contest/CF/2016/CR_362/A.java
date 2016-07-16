import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int t = sc.nextInt();
		int s = sc.nextInt();
		int x = sc.nextInt();
		if (t == x || ((x - t) % s == 0 && (x - t) >= 0) || ((x - t) % s == 1 && x - t != 1)) System.out.println("YES");
		else System.out.println("NO");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
