import java.util.Scanner;
import java.util.Stack;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N + 1];
		for (int i = 1; i <= N; i++) a[i] = i;
		Stack<Integer>  st = new Stack<Integer>();
		while (M-- > 0) st.add(sc.nextInt());

		StringBuilder sb = new StringBuilder();
		boolean[] use = new boolean[N + 1];
		while (!st.isEmpty()) {
			int pop = st.pop();
			if (!use[pop]) {
				sb.append(pop + "\n");
				use[pop] = true;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!use[i]) sb.append(i + "\n");
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
