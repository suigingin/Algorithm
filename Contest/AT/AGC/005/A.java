import java.util.Scanner;
import java.util.Stack;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		char[] s = sc.next().toCharArray();
		Stack<Character> st = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == 'T') {
				if (st.isEmpty()) cnt++;
				else st.pop();
			} else {
				st.push('S');
			}
		}
		cnt += st.size();
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
