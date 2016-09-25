import java.util.Arrays;
import java.util.Comparator;

class SuffixArray {
	int n, k;
	char[] s;

	Integer[] sa;
	int[] rank;
	int[] tmp;
	int[] lcp;

	public SuffixArray(char[] c) {
		s = c;
		n = c.length;
	}

	int compare_sa(int i, int j, int k) {
		if (rank[i] != rank[j]) {
			return rank[i] - rank[j];
		}
		int ri = i + k <= n ? rank[i + k] : -1;
		int rj = j + k <= n ? rank[j + k] : -1;
		return ri - rj;
	}

	void construct_sa() {
		sa = new Integer[n + 1];
		rank = new int[n + 1];
		tmp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			sa[i] = i;
			rank[i] = (i < n) ? s[i] : -1;
		}

		for (k = 1; k <= n; k *= 2) {
			Arrays.sort(sa, new Comparator<Integer>() {
				@Override
				public int compare(Integer i, Integer j) {
					return compare_sa(i, j, k);
				}
			});
			tmp[sa[0]] = 0;
			for (int i = 1; i <= n; i++) {
				tmp[sa[i]] = tmp[sa[i - 1]] + (compare_sa(sa[i - 1], sa[i], k) < 0 ? 1 : 0);
			}
			for (int i = 0; i <= n; i++) {
				rank[i] = tmp[i];
			}
		}
	}

	void construct_lcp() {
		for (int i = 0; i <= n; i++) {
			rank[sa[i]] = i;
		}
		lcp = new int[n];
		int h = 0;
		for (int i = 0; i < n; i++) {
			int j = sa[rank[i] - 1];
			if (h > 0) {
				h--;
			}
			for (; j + h < n && i + h < n; h++) {
				if (s[j + h] != s[i + h]) {
					break;
				}
			}
			lcp[rank[i] - 1] = h;
		}
	}

	long getSubStringCnt() {
		long res = n - sa[n];
		for (int i = 1; i < n; i++) {
			res += (n - sa[i]) - lcp[i];
		}
		return res;
	}

	long getAllSubStringLen() {
		long res = 0;
		for (int i = 1; i <= n; i++) {
			long len = (n - sa[i]);
			long dup = (i < n) ? lcp[i] : 0;
			res += len * (len + 1) / 2 - dup * (dup + 1) / 2;
		}
		return res;
	}
}
