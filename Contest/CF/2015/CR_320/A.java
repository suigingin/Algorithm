import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int x = sc.nextInt();
		int cnt = 1;
		while (x > 1) {
			if (x % 2 == 1) cnt++;
			x /= 2;
		}
		System.out.println(cnt);
		// 上記処理は Integer.bitCount(cnt)と同じ(ビットシフトより)
	}

	public static void main(String[] args) {
		new A().run();
	}
}
