public class No_246 {
	Scanner sc = new Scanner(System.in);
	int M = 1000000000;

	void run() {
		int l = 0;
		int r = M + 1;
		for (int i = 0; i < 30; i++) {
			int mid = (l + r) / 2;
			System.out.println("? " + mid);
			int ans = sc.nextInt();
			if (ans == 1) l = mid;
			else r = mid;
		}
		System.out.println("! " + l);
	}

	public static void main(String[] args) {
		new No_246().run();
	}
}
