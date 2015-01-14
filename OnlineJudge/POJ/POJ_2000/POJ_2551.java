import java.util.Scanner;

public class POJ_2551 {
	Scanner sc = new Scanner(System.in);

	void run() {
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int cnt = 1;
			while (true) {
				int o = 0;
				for (int i = 0; i < cnt; i++) {
					o *= 10;
					o += 1;
					o %= n;
				}
				if (o == 0) {
					break;
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}

	public static void main(String[] args) {
		new POJ_2551().run();
	}
}
