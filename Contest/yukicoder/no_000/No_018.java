import java.util.Scanner;

public class No_018 {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		String t = "";
		for (int i = 1; i <= s.length(); i++) {
			int move = s.charAt(i - 1) - (i % 26);
			if (move < 65) move += 26;
			t += (char) move;
		}
		System.out.println(t);
	}

	public static void main(String[] args) {
		new No_018().run();
	}
}
