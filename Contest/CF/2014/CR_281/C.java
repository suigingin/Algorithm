import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void solve1() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			l.add(a[i]);
		}
		int m = sc.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
			l.add(b[i]);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Collections.sort(l);
		l.add(l.get(l.size() - 1) + 1);
		int pointA = 0;
		int pointB = 0;
		int max = -Integer.MAX_VALUE / 2;
		for (int i = 0; i < l.size(); i++) {
			int d = l.get(i) - 1;
			int indexA = lower_bound(a, d);
			int indexB = lower_bound(b, d);
			int ppA = (n - indexA) * 3 + indexA * 2;
			int ppB = (m - indexB) * 3 + indexB * 2;
			if (ppA - ppB > max) {
				pointA = ppA;
				pointB = ppB;
				max = ppA - ppB;
			} else if (ppA - ppB == max && ppA > pointA) {
				pointA = ppA;
				pointB = ppB;
			}
		}
		System.out.println(pointA + ":" + pointB);
	}

	void solve2() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) l.add(sc.nextInt());
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) l.add(sc.nextInt());
		Info[] info = new Info[n + m];
		for (int i = 0; i < n + m; i++) info[i] = new Info(i < n ? "my" : "you", l.get(i));
		Arrays.sort(info);
		int maxM, maxY, tmpM, tmpY;
		maxM = tmpM = n * 3;
		maxY = tmpY = m * 3;
		for (int i = 0; i < info.length; i++) {
			if (info[i].team.equals("my")) tmpM--;
			else tmpY--;
			while (i + 1 < info.length && info[i].d == info[i + 1].d) {
				if(info[i+1].team.equals("my")) tmpM--;
				else tmpY--;
				i++;
			}
			if (tmpM - tmpY > maxM - maxY) {
				maxM = tmpM;
				maxY = tmpY;
			}
		}
		System.out.println(maxM + ":" + maxY);
	}

	class Info implements Comparable<Info> {
		String team;
		int d;

		public Info(String team, int d) {
			this.team = team;
			this.d = d;
		}

		@Override
		public int compareTo(Info arg0) {
			return this.d - arg0.d;
		}
	}

	public static void main(String[] args) {
		new C().solve2();
	}

	// find minimum i (a[i] > border)
	int lower_bound(int a[], int border) {
		int l = -1;
		int r = a.length;

		while (r - l > 1) {
			int mid = (l + r) / 2;
			if (border < a[mid]) {
				r = mid;
			} else {
				l = mid;
			}
		}
		// r = l + 1
		return r;
	}
}
