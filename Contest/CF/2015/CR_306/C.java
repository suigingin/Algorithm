import java.util.ArrayList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		String in = sc.next();

		ArrayList<Integer> under3 = new ArrayList<Integer>();

		for (int b = 0; b <= 1000; b += 8) under3.add(b);

		for (int i = 0; i < under3.size(); i++) {
			String need = String.valueOf(under3.get(i));
			int index = 0;
			for (int j = 0; j < in.length(); j++) {
				if (need.charAt(index) == in.charAt(j)) index++;
				if (index == need.length()) {
					System.out.println("YES\n" + need);
					return;
				}
			}
		}
		System.out.println("NO");
	}

	public static void main(String[] args) {
		new C().run();
	}
}
