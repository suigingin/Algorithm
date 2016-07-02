import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unused")
	void run() {
		int n = sc.nextInt();
		int d = sc.nextInt();
		int max = 0;
		int c = 0;
		for (int i = 0; i < d; i++) {
			String line = sc.next();
			if (line.contains("0")) c++;
			else c = 0;
			max = Math.max(max, c);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
