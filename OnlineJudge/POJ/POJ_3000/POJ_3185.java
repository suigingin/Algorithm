import java.util.Scanner;

public class POJ_3185 {
	Scanner sc = new Scanner(System.in);
	int cnt = 0;

	void run() {
		int N = 20;
		int ans = 30;
		int[] b = new int[N];
		int[] a = new int[N];
		for (int i = 0; i < N; i++) a[i] = sc.nextInt();
		for (int i = 0; i < N; i++) b[i] = a[i];
		flip(b, 0);
		for (int i = 1; i < N; i++) if (b[i - 1] == 1) flip(b, i);
		if (b[N - 1] == 0) ans = Math.min(ans, cnt);
		cnt = 0;
		for (int i = 0; i < N; i++) b[i] = a[i];
		for (int i = 1; i < N; i++) if (b[i - 1] == 1) flip(b, i);
		if (b[N - 1] == 0) ans = Math.min(ans, cnt);
		System.out.println(ans);
	}

	void flip(int[] a, int p) {
		cnt++;
		a[p] ^= 1;
		if (p - 1 >= 0) a[p - 1] ^= 1;
		if (p + 1 < 20) a[p + 1] ^= 1;
	}

	public static void main(String[] args) {
		new POJ_3185().run();
	}
}
