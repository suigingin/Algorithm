import java.util.LinkedList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] degree = new int[n];
		int[] xor = new int[n];
		LinkedList<Integer> leaf = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			degree[i] = sc.nextInt();
			xor[i] = sc.nextInt();
			if (degree[i] == 1) leaf.add(i);
		}

		int cnt = 0;
		StringBuilder out = new StringBuilder();
		while (!leaf.isEmpty()) {
			int v = leaf.poll();
			if (degree[v] != 1) continue;
			out.append(v + " " + xor[v] + "\n");
			cnt++;
			degree[xor[v]]--;
			xor[xor[v]] ^= v;
			if (degree[xor[v]] == 1) leaf.add(xor[v]);
		}
		out.insert(0, cnt + "\n");
		System.out.print(out);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
