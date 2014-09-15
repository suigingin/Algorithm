import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Diameter {

	Scanner sc = new Scanner(System.in);

	int N;
	boolean[] visit;
	ArrayList<Integer>[] list;

	@SuppressWarnings("unchecked")
	void run() {
		N = sc.nextInt();
		visit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		Node first = dfs(1, 0);
		Arrays.fill(visit, false);
		Node second = dfs(first.num, 0);
		System.out.println(first.num + " " + second.num);
	}

	Node dfs(int now, int depth) {
		Node node = new Node(now, depth);
		visit[now] = true;
		for (int next : list[now]) {
			if (!visit[next]) {
				Node nextN = dfs(next, depth + 1);
				if (node.depth < nextN.depth) {
					node = nextN;
				}
			}
		}
		return node;
	}

	class Node {
		int num;
		int depth;

		public Node(int num, int depth) {
			super();
			this.num = num;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		new Diameter().run();
	}
}

