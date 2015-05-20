import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		int cnt = 1;
		int now = -h[0];
		for (int i = 0; i < n - 1; i++) {
			if (x[i] - h[i] > now || x[i] + h[i] < x[i + 1]) cnt++;
			now = x[i] - h[i] > now || x[i] + h[i] >= x[i + 1] ? x[i] : x[i] + h[i];
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
