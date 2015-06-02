import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		char[] c = sc.next().toCharArray();
		String[] key = { "qwertyuiop", "asdfghjkl;", "zxcvbnm,./" };
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (key[j].indexOf(c[i]) >= 0) {
					if (s.equals("R")) c[i] = key[j].charAt(key[j].indexOf(c[i]) - 1);
					else               c[i] = key[j].charAt(key[j].indexOf(c[i]) + 1);
					break;
				}
			}
		}
		System.out.println(String.valueOf(c));
	}

	public static void main(String[] args) {
		new A().run();
	}
}
