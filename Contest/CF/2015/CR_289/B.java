import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);
	void run() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		int min = 100;
		int max = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		if (max - min > k) {
			System.out.println("NO");
			return;
		}
		StringBuilder out = new StringBuilder("YES\n");
		for (int i = 0; i < n; i++) {
			int c = 1;
			for (int j = 0; j < a[i]; j++) {
				out.append(c++ +" ");
				if(c > k) c = 1;
			}
			out.append("\n");
		}
		System.out.print(out);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
