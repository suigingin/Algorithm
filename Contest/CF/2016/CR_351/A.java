import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		boolean[] t = new boolean[200];
		for (int i = 0; i < n; i++) t[sc.nextInt()] = true;
		int r = 0;
		for (int i = 1, a = 0; i <= 90; i++) {
			if (t[i]) a = 0;
			else a++;
			r++;
			if (a == 15) break;
		}
		System.out.println(r);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
