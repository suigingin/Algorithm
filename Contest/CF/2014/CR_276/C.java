import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		while (n-- > 0) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			long minN = l;
			for (int i = 0; l <= r; i++) {
				if ((l & (1L << i)) == 0) {
					l |= (1L << i);
					if (l <= r) minN = l;
				}
			}
			System.out.println(minN);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}
}
