import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		String teamA = sc.next();
		String teamB = sc.next();
		int n = sc.nextInt();
		int[] ca = new int[100];
		int[] cb = new int[100];
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			String team = sc.next();
			int m = sc.nextInt();
			String card = sc.next();
			if (team.equals("h")) {
				if (ca[m] >= 2) continue;
				ca[m] += card.equals("y") ? 1 : 2;
				if (ca[m] >= 2) System.out.println(teamA + " " + m + " " + t);
			} else {
				if (cb[m] >= 2) continue;
				cb[m] += card.equals("y") ? 1 : 2;
				if (cb[m] >= 2) System.out.println(teamB + " " + m + " " + t);
			}
		}
	}

	public static void main(String[] args) {
		new A().run();
	}
}
