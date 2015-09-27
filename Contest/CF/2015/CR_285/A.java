import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int Misha = Math.max(3 * a / 10, a - a / 250 * c);
		int Vasya = Math.max(3 * b / 10, b - b / 250 * d);
		if (Misha == Vasya) {
			System.out.println("Tie");
		} else {
			System.out.println(Misha > Vasya ? "Misha" : "Vasya");
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
