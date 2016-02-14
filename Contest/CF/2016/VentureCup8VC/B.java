import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String s = sc.next();
		int[] c = new int[3];
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'B') c[0]++;
			else if (s.charAt(i) == 'G') c[1]++;
			else c[2]++;
		}
		if (c[0] > 0 && c[1] > 0 && c[2] > 0)           System.out.println("BGR");
		else if (c[0] == 0 && c[1] == 0 && c[2] > 0)    System.out.println("R");
		else if (c[0] == 0 && c[1] > 0 && c[2] == 0)    System.out.println("G");
		else if (c[0] > 0 && c[1] == 0 && c[2] == 0)    System.out.println("B");
		else if (c[0] >= 2 && (c[1] == 1 || c[2] == 1)) System.out.println("GR");
		else if (c[0] >= 2 && (c[1] >= 2 || c[2] >= 2)) System.out.println("BGR");
		else if (c[1] >= 2 && (c[0] == 1 || c[2] == 1)) System.out.println("BR");
		else if (c[1] >= 2 && (c[0] >= 2 || c[2] >= 2)) System.out.println("BGR");
		else if (c[2] >= 2 && (c[1] == 1 || c[0] == 1)) System.out.println("BG");
		else if (c[2] >= 2 && (c[1] >= 2 || c[0] >= 2)) System.out.println("BGR");
		else if (c[0] == 1 && c[1] == 1)                System.out.println("R");
		else if (c[0] == 1 && c[2] == 1)                System.out.println("G");
		else if (c[1] == 1 && c[2] == 1)                System.out.println("B");
	}

	public static void main(String[] args) {
		new B().run();
	}
}
