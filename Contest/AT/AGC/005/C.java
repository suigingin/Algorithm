import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] c = new int[N];
		int dia = 0;
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			dia = Math.max(dia, a[i]);
			c[a[i]]++;
		}

		int centC = (dia % 2 == 0) ? 1 : 2;
		int centD = (dia + 1) / 2;

		for (int i = 0; i < N; i++) {
			if (a[i] < centD) {
				System.out.println("Impossible");
				return;
			}
		}

		for (int i = dia; i >= centD; i--) {
			if (i != centD && c[i] < 2) {
				System.out.println("Impossible");
				return;
			} else if (i == centD && c[i] != centC) {
				System.out.println("Impossible");
				return;
			}
		}
		System.out.println("Possible");
	}

	public static void main(String[] args) {
		new C().run();
	}
}
