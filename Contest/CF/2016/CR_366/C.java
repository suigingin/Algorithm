import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int q = sc.nextInt();
		List<Pair> o = new ArrayList<>();
		int[] cntA = new int[n];
		int[] index = new int[n];
		StringBuilder s = new StringBuilder();
		int cnt = 0;
		int oI = 0;
		while (q-- > 0) {
			int t = sc.nextInt();
			int p = sc.nextInt() - 1;
			if (t == 1) {
				Pair m = new Pair(cntA[p], p);
				cntA[p]++;
				o.add(m);
				cnt++;
			} else if (t == 2) {
				cnt -= cntA[p] - index[p];
				index[p] = cntA[p];
			} else {
				for (int i = oI; i <= p; i++) {
					Pair m = o.get(i);
					if (m.id >= index[m.app]) {
						index[m.app]++;
						cnt--;
					}
				}
				oI = Math.max(oI, p + 1);
			}
			s.append(cnt + "\n");
		}
		System.out.print(s);
	}

	class Pair {

		int id;
		int app;

		public Pair(int id, int app) {
			super();
			this.id = id;
			this.app = app;
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
