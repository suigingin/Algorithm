import java.util.HashSet;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i <= s.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				StringBuilder sb = new StringBuilder(s).insert(i, c);
				set.add(sb.toString());
			}
		}
		System.out.println(set.size());
	}

	public static void main(String[] args) {
		new A().run();
	}
}
