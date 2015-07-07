import java.util.Arrays;
import java.util.Scanner;

public class No_005 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (sum + a[i] <= L) sum += a[i];
			else break;
			cnt++;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new No_005().run();
	}
}
