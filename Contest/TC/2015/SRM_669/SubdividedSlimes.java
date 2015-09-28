import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SubdividedSlimes {
	Scanner sc = new Scanner(System.in);

	public int needCut(int S, int M) {
		for (int i = 2; i <= S; i++) {
			if (ok(S, M, i)) return i - 1;
		}
		return -1;
	}

	boolean ok(int S, int M, int k) {
		// Sをk個に均等分割
		// (相加相乗平均より均等に分けた方が積を最大化できる)
		int[] A = new int[k];
		int res = 0;
		int sum = 0;
		for (int i = 0; i < k; i++) A[i] = (S / k) + (i < S % k ? 1 : 0);
		for (int i = 0; i < k; i++) {
			res += sum * A[i];
			sum += A[i];
		}
		return res >= M;
	}

	// Greedyではだめ
	public int wrong(int S, int M) {
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		que.add(S);
		int cut = 0;
		int m = 0;
		while (m < M) {
			int max = que.poll();
			if (max == 1) return -1;
			if (max % 2 == 0) {
				m += max / 2 * max / 2;
				que.add(max / 2);
				que.add(max / 2);
			} else {
				m += max / 2 * (max + 1) / 2;
				que.add(max / 2);
				que.add((max + 1) / 2);
			}
			cut++;
		}
		return cut;
	}
}
