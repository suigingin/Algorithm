import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] a = new int[3];
		Arrays.fill(a, y);
		int cnt = 0;
		while (a[0] != x) {
			cnt++;
			a[0] = Math.min(x, a[1] + a[2] - 1);
			Arrays.sort(a);
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
