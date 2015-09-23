import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long area1 = a * x1 + b * y1 + c;
			long area2 = a * x2 + b * y2 + c;
			if ((area1 < 0 && area2 > 0) || (area1 > 0 && area2 < 0)) cnt++;
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
