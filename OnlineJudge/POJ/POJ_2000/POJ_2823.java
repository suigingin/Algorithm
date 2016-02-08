import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class POJ_2823 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		int[] min = getSlideMin(a, n, k);
		int[] max = getSlideMax(a, n, k);
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < n - k + 1; i++) out.append((i == 0 ? "" : " ") + min[i]);
		out.append("\n");
		for (int i = 0; i < n - k + 1; i++) out.append((i == 0 ? "" : " ") + max[i]);
		System.out.println(out);
	}

	int[] getSlideMin(int[] a, int n, int k) {
		int[] b = new int[n - k + 1];
		Deque<Integer> deq = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (deq.isEmpty()) {
				deq.add(i);
			} else {
				while (!deq.isEmpty() && a[deq.peekLast()] >= a[i]) deq.pollLast();
				deq.addLast(i);
			}
			if (i - k + 1 >= 0) {
				b[i - k + 1] = a[deq.peekFirst()];
				if (deq.peekFirst() == i - k + 1) deq.pollFirst();
			}
		}
		return b;
	}

	int[] getSlideMax(int[] a, int n, int k) {
		int[] b = new int[n - k + 1];
		Deque<Integer> deq = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (deq.isEmpty()) {
				deq.add(i);
			} else {
				while (!deq.isEmpty() && a[deq.peekLast()] <= a[i]) deq.pollLast();
				deq.addLast(i);
			}
			if (i - k + 1 >= 0) {
				b[i - k + 1] = a[deq.peekFirst()];
				if (deq.peekFirst() == i - k + 1) deq.pollFirst();
			}
		}
		return b;
	}

	public static void main(String[] args) {
		new POJ_2823().run();
	}
}
