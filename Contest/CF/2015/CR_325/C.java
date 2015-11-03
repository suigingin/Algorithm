import java.util.ArrayList;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	int n;
	long[] v, d, p;
	boolean[] end;

	void run() {
		n = sc.nextInt();

		// v:診察室での泣き声の大きさ(外のひとv人までダメージ)
		// d:待合室での泣き声の大きさ
		// p:自信(0未満になると帰宅し、全員にdのダメージ)
		v = new long[n];
		d = new long[n];
		p = new long[n];
		for (int i = 0; i < n; i++) {
			v[i] = sc.nextLong();
			d[i] = sc.nextLong();
			p[i] = sc.nextLong();
		}

		// 診察が終わった or 途中で帰った
		end = new boolean[n];

		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {

			// 無事診察室へ入った
			if (!end[i]) {
				end[i] = true;
				l.add(i + 1);
				ArrayList<Integer> down = new ArrayList<Integer>();
				for (int j = i + 1; v[i] > 0 && j < n; j++) {
					if (!end[j]) {
						p[j] -= v[i]--;
						if (p[j] < 0) {
							down.add(j);
							end[j] = true;
						}
					}
				}
				for (Integer ele : down) {
					allDamage(ele);
				}
			}
		}
		System.out.println(l.size());
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < l.size(); i++) out.append(l.get(i) + " ");
		System.out.println(out);
	}

	// now以降の子どもたちにd[now]のダメージ
	void allDamage(int now) {
		for (int i = now + 1; i < n; i++) {
			if (!end[i]) {
				p[i] -= d[now];
				if (p[i] < 0) {
					end[i] = true;
					allDamage(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
