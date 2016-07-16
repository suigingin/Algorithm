import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int min = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (i % 7 == 0) max++;
			if (i % 7 == 1) max++;
			if (i % 7 == 5) min++;
			if (i % 7 == 6) min++;
		}
		System.out.println(min + " " + max);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
