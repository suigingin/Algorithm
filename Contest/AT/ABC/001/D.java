import java.util.Scanner;

public class D {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		String[][] in = new String[n][2];
		for (int i = 0; i < n; i++) in[i] = sc.next().split("-");
		int[] time = new int[1442]; // 1440 = 24 * 60
		for (int i = 0; i < in.length; i++) {
			int s = Integer.valueOf(in[i][0]) / 100 * 60 + Integer.valueOf(in[i][0]) % 100;
			int t = Integer.valueOf(in[i][1]) / 100 * 60 + Integer.valueOf(in[i][1]) % 100;

			int r = s % 10;
			if (r != 0 && r != 5) {
				s -= r;
				if (r > 5) s += 5;
			}
			r = t % 10;
			if (r != 0 && r != 5) {
				t -= r;
				t += r < 5 ? 5 : 10;
			}
			time[s]++;
			time[t + 1]--;
		}

		for (int i = 1; i < time.length; i++) time[i] += time[i - 1];

		for (int i = 0; i < time.length; i++) {
			if (time[i] != 0) {
				int s = i;
				int t = 0;
				while (i < time.length && time[i] != 0) i++;
				t = i - 1;
				String from = "";
				String to = "";
				from += s / 60 < 10 ? "0" + s / 60 : s / 60;
				from += s % 60 < 10 ? "0" + s % 60 : s % 60;
				to += t / 60 < 10 ? "0" + t / 60 : t / 60;
				to += t % 60 < 10 ? "0" + t % 60 : t % 60;
				System.out.println(from + "-" + to);
			}
		}
	}

	public static void main(String[] args) {
		new D().run();
	}
}
