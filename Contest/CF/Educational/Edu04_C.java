import java.util.Scanner;
import java.util.Stack;

public class Edu04_C {
	Scanner sc = new Scanner(System.in);

	void run() {
		String open = "<{[(";
		String close = ">}])";
		String s = sc.next();
		int N = s.length();

		// Open/Closeの括弧数が合わない場合は成立しないためImpossible
		// またCloseの括弧数がOpenより大きくなっても成立しない
		int ocnt = 0;
		int ccnt = 0;
		for (int i = 0; i < N; i++) {
			if (open.indexOf(s.charAt(i)) >= 0) ocnt++;
			if (close.indexOf(s.charAt(i)) >= 0) ccnt++;
			if (ccnt > ocnt) {
				System.out.println("Impossible");
				return;
			}
		}
		if (ocnt != ccnt) {
			System.out.println("Impossible");
			return;
		}
		int res = 0;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if (open.indexOf(c) >= 0) {
				stack.add(c);
			} else {
				char pop = stack.pop();
				if (open.indexOf(pop) != close.indexOf(c)) {
					res++;
				}
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		new Edu04_C().run();
	}
}
