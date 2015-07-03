import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		int a = s.indexOf("AB");
		int b = s.lastIndexOf("BA");
		int c = s.lastIndexOf("AB");
		int d = s.indexOf("BA");
		if ((a >= 0 && b >= 0 && a + 1 < b) || (c >= 0 && d >= 0 && d + 1 < c)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
