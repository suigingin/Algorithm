import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		long need = sc.nextLong() * 6;
		long a = sc.nextLong();
		long b = sc.nextLong();

		if (a * b >= need) {
			System.out.println(a * b);
			System.out.println(a + " " + b);
			return;
		}

		boolean swap = false;
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
			swap = true;
		}

		long min = Long.MAX_VALUE;
		long ma = 0;
		long mb = 0;
		for (long ai = a; ai * ai <= need; ai++) {
			long bi = need / ai;
			if (bi < b) continue;
			if (ai * bi < need) bi++;
			if (ai * bi < min) {
				min = ai * bi;
				ma = ai;
				mb = bi;
			}
		}
		System.out.println(min);
		System.out.println(swap ? (mb + " " + ma) : (ma + " " + mb));
	}

	public static void main(String[] args) {
		new B().run();
	}
}
