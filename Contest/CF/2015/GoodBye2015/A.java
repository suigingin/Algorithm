import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String[] s = sc.nextLine().split(" ");
		int x = Integer.valueOf(s[0]);
		int out = 0;
		if (s[2].equals("month")) {
			if (x == 30) out = 11;
			else if (x == 31) out = 7;
			else out = 12;
		} else {
			if (x == 5 || x == 6) out = 53;
			else out = 52;
		}
		System.out.println(out);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
