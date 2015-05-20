import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		String t = sc.next();
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) diff++;
		}
		if (diff % 2 == 1) {
			System.out.println("impossible");
			return;
		}
		StringBuilder p = new StringBuilder();
		int sdiff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i) && sdiff != diff / 2) {
				p.append(t.charAt(i));
				sdiff++;
			} else {
				p.append(s.charAt(i));
			}
		}
		System.out.println(p);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
