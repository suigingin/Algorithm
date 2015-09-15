import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String s = sc.next();
		String min = "";
		for (int i = 0; i < n; i++) min += "9";
		for (int i = 0; i < n; i++) {
			char[] shift = new char[n];
			for (int j = 0; j < n; j++) shift[(j + 1) % n] = s.charAt(j);
			for (int j = 1; j <= 10; j++) {
				for (int k = 0; k < n; k++)  shift[k] = (char) (((shift[k] + 1 - '0') % 10) + '0');
				if (min.compareTo(String.valueOf(shift)) > 0) min = String.valueOf(shift);
			}
			s = String.valueOf(shift);
		}
		System.out.println(min);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
