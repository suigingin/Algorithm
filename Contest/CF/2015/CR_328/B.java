import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		long cnt = 0;
		cnt += n - 2;
		for (int i = 0; i < n - 2; i++) cnt += n - 3;
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
