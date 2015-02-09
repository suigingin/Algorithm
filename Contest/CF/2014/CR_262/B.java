import java.util.ArrayList;

public class B {
	MyScanner sc = new MyScanner();

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 81; i++) {
			int x = (int) (b * Math.pow(i, a) + c);
			int digitSum = 0;
			String strX = String.valueOf(x);
			for (int j = 0; j < strX.length(); j++) {
				digitSum += strX.charAt(j) - '0';
			}
			if (digitSum == i && 0 < x && x < 1000000000) {
				list.add(x);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		new B().run();
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}

	}
}
