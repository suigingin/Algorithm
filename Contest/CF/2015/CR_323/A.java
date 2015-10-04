import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		boolean[] hf = new boolean[n];
		boolean[] wf = new boolean[n];
		StringBuilder out = new StringBuilder();
		for (int i = 1; i <= n * n; i++) {
			int h = sc.nextInt() - 1;
			int w = sc.nextInt() - 1;
			if (!hf[h] && !wf[w]) {
				hf[h] = true;
				wf[w] = true;
				out.append(i + " ");
			}
		}
		System.out.println(out);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
