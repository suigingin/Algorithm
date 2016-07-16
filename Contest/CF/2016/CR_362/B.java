import java.math.BigDecimal;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		String[] s = sc.next().split("e");
		String cut = "";
		if (s[1].equals("0")) {
			cut = cutZero(s[0]);
		} else {
			BigDecimal A = new BigDecimal(s[0]);
			BigDecimal B = new BigDecimal("10");
			String ss = (A.multiply(B.pow(Integer.valueOf(s[1])))).toString();
			cut = cutZero(ss);
		}
		if (cut.charAt(cut.length() - 1) == '.') cut = cut.substring(0, cut.length() - 1);
		System.out.println(cut);
	}

	String cutZero(String s) {
		int cut = s.length();
		for (int i = cut - 1;; i--) {
			if (s.charAt(i) == '0') cut--;
			else break;
		}
		return s.substring(0, cut);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
