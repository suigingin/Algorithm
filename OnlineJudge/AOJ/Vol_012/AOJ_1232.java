import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AOJ_1232 {
	Scanner sc = new Scanner(System.in);

	void run() {

		boolean[] isPrime = new boolean[100000];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i < 100000; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * 2; j < 100000; j += i) isPrime[j] = false;
		}

		ArrayList<Double> l = new ArrayList<Double>();
		for (int i = 0; i < 100000; i++) {
			if (isPrime[i]) l.add((double) i);
		}

		for (;;) {
			int m = sc.nextInt();
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double max = 0;
			double pp = 0;
			double qq = 0;
			if (m == 0) return;
			for (int i = 0; i < l.size(); i++) {
				for (int j = i; j < l.size(); j++) {
					double p = l.get(i);
					double q = l.get(j);
					if (p * q > m || a / b > p / q) break;
					if (max < p * q) {
						max = p * q;
						pp = p;
						qq = q;
					}
				}
			}
			System.out.println((int) pp + " " + (int) qq);
		}
	}

	public static void main(String[] args) {
		new AOJ_1232().run();
	}
}
