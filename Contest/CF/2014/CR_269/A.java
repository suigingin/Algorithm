import java.util.Arrays;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] cnt = new int[10];
		for (int i = 0; i < 6; i++) cnt[sc.nextInt()]++;
		Arrays.sort(cnt);
		if (cnt[9] < 4)                      System.out.println("Alien");
		else if (cnt[9] == 6 || cnt[8] == 2) System.out.println("Elephant");
		else                                 System.out.println("Bear");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
