import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long sum = 0;
		long min = Integer.MAX_VALUE / 2;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if ((a & 1) == 1) min = Math.min(min, a);
			sum += a;
		}
		if ((sum & 1) == 1) sum -= min;
		System.out.println(sum);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
