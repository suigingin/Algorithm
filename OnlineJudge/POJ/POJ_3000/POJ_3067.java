import java.util.Arrays;

public class POJ_3067 {
	MyScanner sc = new MyScanner();
	int N, M, K;
	long cnt;

	void run() {
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			Pair[] p = new Pair[K];
			for (int i = 0; i < K; i++) p[i] = new Pair(sc.nextInt(), sc.nextInt());
			Arrays.sort(p);
			int[] a = new int[K];
			for (int i = 0; i < K; i++) a[i] = p[i].b;
			mergeSort(a, 0, a.length);
			System.out.println("Test case " + t + ": " + cnt);
		}
	}

	void mergeSort(int a[], int left, int right) {
		if (right - left <= 1) return;
		int mid = (left + right) / 2;
		mergeSort(a, left, mid);
		mergeSort(a, mid, right);
		merge(a, left, mid, right);
	}

	void merge(int[] a, int left, int mid, int right) {
		int[] L = new int[mid - left];
		int[] R = new int[right - mid];
		int li = 0;
		int ri = 0;
		for (int i = 0; i < L.length; i++) L[i] = a[left + i];
		for (int i = 0; i < R.length; i++) R[i] = a[mid + i];
		for (int i = left; i < right; i++) {
			if (li < L.length && (ri == R.length || L[li] <= R[ri])) {
				a[i] = L[li++];
			} else {
				cnt += (mid - li - left);
				a[i] = R[ri++];
			}
		}
	}

	class Pair implements Comparable<Pair> {

		int a;
		int b;

		public Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (this.a == arg0.a) {
				return this.b - arg0.b;
			}
			return this.a - arg0.a;
		}
	}

	public static void main(String[] args) {
		new POJ_3067().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}
	}
}
