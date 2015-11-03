import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		char[][] f = new char[8][8];
		for (int i = 0; i < 8; i++) f[i] = sc.next().toCharArray();
		int Astep = 100;
		int Bstep = 100;
		// checkA
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (f[j][i] == 'B') break;
				if (f[j][i] == 'W') Astep = Math.min(Astep, j);
			}
		}
		// checkB
		for (int i = 0; i < 8; i++) {
			for (int j = 7; j >= 0; j--) {
				if (f[j][i] == 'W') break;
				if (f[j][i] == 'B') Bstep = Math.min(Bstep, 7 - j);
			}
		}
		System.out.println(Astep <= Bstep ? "A" : "B");
	}

	public static void main(String[] args) {
		new A().run();
	}
}
