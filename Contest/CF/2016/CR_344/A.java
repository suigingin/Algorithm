import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int A = 0;
		int B = 0;
		for (int i = 0; i < n; i++) A |= sc.nextInt();
		for (int i = 0; i < n; i++) B |= sc.nextInt();
		System.out.println(A + B);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
