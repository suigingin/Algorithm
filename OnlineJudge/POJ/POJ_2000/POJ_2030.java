import java.util.Scanner;

public class POJ_2030 {
	Scanner sc = new Scanner(System.in);

	void run() {
		for (;;) {
			int W = sc.nextInt();
			int H = sc.nextInt();
			if ((W | H) == 0) return;
			char[][] f = new char[H][W];
			for (int i = 0; i < H; i++) {
				String in = sc.next();
				for (int j = 0; j < W; j++) {
					f[i][j] = in.charAt(j);
				}
			}
			String[][] s = new String[H][W];
			String max = "";
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (Character.isDigit(f[i][j])) {
						String set1 = f[i][j] + "";
						String set2 = f[i][j] + "";
						if (i - 1 >= 0 && Character.isDigit(f[i - 1][j])) set1 = s[i - 1][j] + set1;
						if (j - 1 >= 0 && Character.isDigit(f[i][j - 1])) set2 = s[i][j - 1] + set2;

						if (set1.length() > set2.length())       s[i][j] = set1;
						else if (set1.length() == set2.length()) s[i][j] = (set1.compareTo(set2) > 0) ? set1 : set2;
						else                                     s[i][j] = set2;

						if (s[i][j].length() == 1 && s[i][j].equals("0")) {
							s[i][j] = "";
							continue;
						}

						if (s[i][j].length() > max.length())                                     max = s[i][j];
						else if (s[i][j].length() == max.length() && s[i][j].compareTo(max) > 0) max = s[i][j];
					}
				}
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new POJ_2030().run();
	}
}
