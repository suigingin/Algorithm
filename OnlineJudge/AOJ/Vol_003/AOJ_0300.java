import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class AOJ_0300 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		while (N-- > 0) {
			int[] p = new int[30];
			for (int i = 0; i < 30; i++) p[i] = sc.nextInt();
			int cnt = 0;
			LinkedList<int[]> que = new LinkedList<int[]>();
			HashSet<String> set = new HashSet<String>();
			que.add(p);
			set.add(Arrays.toString(p));
			L: while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int[] now = que.poll();
					if (goal(now)) break L;
					int[] next1 = new int[30];
					int[] next2 = new int[30];
					int[] next3 = new int[30];
					int[] next4 = new int[30];
					for (int j = 0; j < 30; j++) {
						next1[j] = now[j];
						next2[j] = now[j];
						next3[j] = now[j];
						next4[j] = now[j];
					}
					swap(next1, 6, 21);
					swap(next1, 7, 22);
					swap(next1, 8, 23);
					swap(next1, 12, 17);
					swap(next1, 9, 11);
					swap(next2, 0, 27);
					swap(next2, 1, 28);
					swap(next2, 2, 29);
					swap(next2, 14, 15);
					swap(next2, 18, 20);
					swap(next3, 0, 23);
					swap(next3, 3, 26);
					swap(next3, 6, 29);
					swap(next3, 9, 20);
					swap(next3, 15, 17);
					swap(next4, 2, 21);
					swap(next4, 5, 24);
					swap(next4, 8, 27);
					swap(next4, 11, 18);
					swap(next4, 12, 14);
					if (!set.contains(Arrays.toString(next1))) {
						set.add(Arrays.toString(next1));
						que.add(next1);
					}
					if (!set.contains(Arrays.toString(next2))) {
						set.add(Arrays.toString(next2));
						que.add(next2);
					}
					if (!set.contains(Arrays.toString(next3))) {
						set.add(Arrays.toString(next3));
						que.add(next3);

					}
					if (!set.contains(Arrays.toString(next4))) {
						set.add(Arrays.toString(next4));
						que.add(next4);
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}

	boolean goal(int p[]) {
		for (int i = 0; i < 8; i++)   if (p[i] != p[i + 1]) return false;
		for (int i = 9; i < 11; i++)  if (p[i] != p[i + 1]) return false;
		for (int i = 12; i < 14; i++) if (p[i] != p[i + 1]) return false;
		for (int i = 15; i < 17; i++) if (p[i] != p[i + 1]) return false;
		for (int i = 18; i < 20; i++) if (p[i] != p[i + 1]) return false;
		for (int i = 21; i < 29; i++) if (p[i] != p[i + 1]) return false;
		return true;
	}

	public static void main(String[] args) {
		new AOJ_0300().run();
	}

	void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}
}
