import java.util.Scanner;
import java.util.TreeSet;

public class No_237 {
	Scanner sc = new Scanner(System.in);
	int M = 1000000000;

	void run() {
		int n = sc.nextInt();
		TreeSet<Long> set = new TreeSet<>();
		int[] F = { 3, 5, 17, 257, 65537 };
		for (int mask = 0; mask < 1 << F.length; mask++) {
			long base = 1;
			for (int j = 0; j < F.length; j++) {
				if ((mask >> j & 1) == 1) {
					base *= F[j];
				}
			}
			while (base <= M) {
				set.add(base);
				base *= 2;
			}
		}
	
		set.remove(1L);
		set.remove(2L);
		
		int cnt = 0;
		for (long val : set) {
			if(val <= n) cnt++;
			else break;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new No_237().run();
	}
}
