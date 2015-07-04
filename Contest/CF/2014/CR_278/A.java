import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		long a = sc.nextLong() + 1;
		int cnt = 1;
		while (true) {
			String s = a + "";
			if (s.indexOf("8") >= 0) {
				System.out.println(cnt);
				return;
			}
			a++;
			cnt++;
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
