import java.util.LinkedList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		sc.nextInt();
		LinkedList<Integer>one = new LinkedList<Integer>();
		LinkedList<Integer>two = new LinkedList<Integer>();
		int k1 = sc.nextInt();
		for (int i = 0; i < k1; i++) one.add(sc.nextInt());
		int k2 = sc.nextInt();
		for (int i = 0; i < k2; i++) two.add(sc.nextInt());
		for (int turn = 0; turn < 1000; turn++) {
			if (one.isEmpty() || two.isEmpty()) {
				System.out.println(turn + " " + (one.isEmpty() ? 2 : 1));
				return;
			}
			int oCard = one.poll();
			int tCard = two.poll();
			if (oCard < tCard) {
				two.add(oCard);
				two.add(tCard);
			} else {
				one.add(tCard);
				one.add(oCard);
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
