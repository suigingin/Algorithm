import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		long[] ball = new long[3];
		for (int i = 0; i < 3; i++) ball[i] = sc.nextLong();
		Arrays.sort(ball);
		if ((ball[0] + ball[1]) * 2 <= ball[2]) System.out.println(ball[0] + ball[1]);
		else System.out.println((ball[0] + ball[1] + ball[2]) / 3);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
