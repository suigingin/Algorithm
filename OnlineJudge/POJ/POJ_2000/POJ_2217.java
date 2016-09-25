import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class POJ_2217 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		sc.nextLine();
		while (N-- > 0) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			int l1 = s1.length();
			int max = 0;
			SuffixArray SA = new SuffixArray((s1 + '¥' + s2).toCharArray());
			SA.construct_sa();
			SA.construct_lcp();
			for (int i = 0; i < SA.n; i++) {
				if (SA.sa[i] < l1 && SA.sa[i + 1] < l1) continue;
				if (l1 <= SA.sa[i] && l1 <= SA.sa[i + 1]) continue;
				max = Math.max(max, SA.lcp[i]);
			}
			System.out.println("Nejdelsi spolecny retezec ma delku " + max + ".");
		}
	}

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

		void dump() {
			StringBuilder sb = new StringBuilder();
			sb.append("i | sa[i] | lcp[i] | S[sa[i]]...]\n");
			for (int i = 0; i <= n; i++) {
				sb.append(i + " | ");
				sb.append(sa[i] + " | ");
				sb.append((i < n ? lcp[i] : "-") + " | ");
				for (int j = sa[i]; j < n; j++) {
					sb.append(s[j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
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

	public static void main(String[] args) {
		new POJ_2217().run();
	}
}
