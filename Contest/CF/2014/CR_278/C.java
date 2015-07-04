import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		int hpY = sc.nextInt();
		int atY = sc.nextInt();
		int deY = sc.nextInt();
		int hpM = sc.nextInt();
		int atM = sc.nextInt();
		int deM = sc.nextInt();
		int h = sc.nextInt();
		int a = sc.nextInt();
		int d = sc.nextInt();

		int cost = Integer.MAX_VALUE;

		for (int i = 0; i < 200; i++) {
			for (int j = 0; j < 100; j++) {
				int AT = atY + i;
				int DE = deY + j;

				if (AT - deM <= 0) continue;

				int t = (hpM % (AT - deM) == 0) ? hpM / (AT - deM) : hpM / (AT - deM) + 1;
				int allDamage = Math.max(0, atM - DE) * t;

				if (hpY - allDamage <= 0) cost = Math.min(cost, i * a + j * d + (allDamage - hpY + 1) * h);
				else cost = Math.min(cost, i * a + j * d);
			}
		}
		System.out.println(cost);
	}

	public static void main(String[] args) {
		new C().run();
	}
}
