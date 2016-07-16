import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 1000; i++) sb.append(i);
		System.out.println(sb.charAt(n - 1));
	}

	public static void main(String[] args) {
		new A().run();
	}
}
