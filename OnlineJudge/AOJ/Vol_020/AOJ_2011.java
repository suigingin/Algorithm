import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AOJ_2011 {
	Scanner sc = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	void run() {
		for (;;) {
			int N = sc.nextInt();
			if (N == 0) return;
			ArrayList<Integer>[] l = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				l[i] = new ArrayList<Integer>();
				int f = sc.nextInt();
				for (int j = 0; j < f; j++) {
					l[i].add(sc.nextInt());
				}
			}

			HashSet<Integer>[] set = new HashSet[N];
			for (int i = 0; i < N; i++) {
				set[i] = new HashSet<Integer>();
				set[i].add(i);
			}

			int ans = -1;
			L: for (int i = 1; i <= 30; i++) {
				// i日に予定の合うfox情報
				ArrayList<Integer> match = new ArrayList<Integer>();
				for (int j = 0; j < N; j++) {
					if (l[j].contains(i)) {
						match.add(j);
					}
				}
				
				// それぞれの持つ情報を集約
				HashSet<Integer> all = new HashSet<Integer>();
				for (int j = 0; j < match.size(); j++) {
					for (Integer fox : set[match.get(j)]) {
						all.add(fox);
					}
				}
				for (int j = 0; j < match.size(); j++) {
					for (Integer fox : all) {
						set[match.get(j)].add(fox);
					}
				}
				
				// 全て情報が集まったか
				for (int j = 0; j < N; j++) {
					if (set[j].size() == N) {
						ans = i;
						break L;
					}
				}
			}
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		new AOJ_2011().run();
	}
}
