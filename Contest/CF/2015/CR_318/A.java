import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int my = sc.nextInt();
		int cnt = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		for (int i = 0; i < n - 1; i++) pq.add(sc.nextInt());
		while (my <= pq.peek()) {
			int max = pq.poll();
			max--;
			my++;
			cnt++;
			pq.add(max);
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
