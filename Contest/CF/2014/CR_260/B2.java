import java.util.Scanner;

public class B2 {
	Scanner sc = new Scanner(System.in);

	void run() {
		String in = sc.next();
		int mod = 0;
		for (int i = 0; i < in.length(); i++) {
			mod *= 10;
			mod += in.charAt(i) - '0';
			mod %= 4;
		}
		System.out.println(mod % 4 == 0 ? 4 : 0);
	}

	public static void main(String[] args) {
		new B2().run();
	}
}
