import java.util.Arrays;
import java.util.Scanner;

public class No_021 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int N = sc.nextInt(); sc.nextInt();
		int[] n = new int[N];
		for (int i = 0; i < N; i++) n[i] = sc.nextInt();
		Arrays.sort(n);
		int max = n[N - 1];
		int min = n[0];
		System.out.println(max - min);
	}

	public static void main(String[] args) {
		new No_021().run();
	}
}
