import java.util.Scanner;
import java.util.Stack;

public class No_022 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int K = sc.nextInt();
		String s = sc.next();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '(') stack.add(i + 1);
			else {
				int num = stack.pop();
				if ((i + 1) == K) System.out.println(num);
				if (num == K) System.out.println(i + 1);
			}
		}
	}

	public static void main(String[] args) {
		new No_022().run();
	}
}
