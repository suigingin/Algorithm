import java.util.Scanner;

public class No_026 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt() - 1;
		int M = sc.nextInt();
		int[] cup = new int[3];
		cup[N] = 1;
		while (M-- > 0) {
			swap(cup, sc.nextInt() - 1, sc.nextInt() - 1);
		}
		for (int i = 0; i < 3; i++) {
			if (cup[i] == 1) System.out.println(i + 1);
		}
	}

	void swap(int[] x, int a, int b) {
		int tmp = x[a];
		x[a] = x[b];
		x[b] = tmp;
	}

	public static void main(String[] args) {
		new No_026().run();
	}
}
