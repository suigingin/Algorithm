import java.util.Scanner;

public class AOJ_0099_1 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int nn = sc.nextInt();
		q = sc.nextInt();
		n = 1;
		while (n < nn) n *= 2;
		init();
		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			int a = sc.nextInt() - 1;
			int v = sc.nextInt();
			update(a, v);
			sb.append(id[0] + 1 + " " + dat[0] + "\n");
		}
		System.out.print(sb);
	}

	int n, q;
	int dat[];
	int id[];

	void init() {
		dat = new int[n * 2 - 1];
		id = new int[n * 2 - 1];
		for (int i = 0; i < n; i++) id[i + n - 1] = i;
	}

	void update(int i, int x) {
		i += n - 1;
		dat[i] += x;
		while (i > 0) {
			i = (i - 1) / 2;
			if (dat[i * 2 + 1] >= dat[i * 2 + 2]) {
				dat[i] = dat[i * 2 + 1];
				id[i] = id[i * 2 + 1];
			} else {
				dat[i] = dat[i * 2 + 2];
				id[i] = id[i * 2 + 2];
			}
		}
	}

	public static void main(String[] args) {
		new AOJ_0099_1().run();
	}
}
