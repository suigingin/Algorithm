import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		StringBuilder s = new StringBuilder("I hate");
		for (int i = 1; i < n; i++) s.append(i % 2 == 1 ? " that I love" : " that I hate");
		s.append(" it");
		System.out.println(s);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
