import java.util.Scanner;

public class E {
	Scanner sc = new Scanner(System.in);

	void run() {
		String s = sc.next();
		String v = "IEAOUY";
		int n = s.length();
		double[] A = new double[n];
		double[] B = new double[n];
		A[0] = 1;
		B[0] = 1;
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] + 1 / (i + 1.0);
			B[i] = B[i - 1] + A[i];
		}
		double res = 0;
		int l = -1;
		int r = n - 2;
		for (int i = 0; i < n; i++) {
			if (v.indexOf(s.charAt(i)) >= 0) {
				res += B[n - 1];
				if (l >= 0) res -= B[l];
				if (r >= 0) res -= B[r];
			}
			l++;
			r--;
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		new E().run();
	}
}
