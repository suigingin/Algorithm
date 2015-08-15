import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt[] = new int[n];
		for (int i = 0; i < m; i++) {
			int max = 0;
			int maxInd = 0;
			for (int j = 0; j < n; j++) {
				int get = sc.nextInt();
				if (get > max) {
					max = get;
					maxInd = j;
				}
			}
			cnt[maxInd]++;
		}
		int res = 0;
		int mm = 0;
		for (int i = 0; i < n; i++) {
			if (mm < cnt[i]) {
				mm = cnt[i];
				res = i;
			}
		}
		System.out.println(res + 1);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
