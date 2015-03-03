public class A {
	MyScanner sc = new MyScanner();

	void run() {
		int white = 0;
		int black = 0;
		for (int i = 0; i < 8; i++) {
			String s = sc.next();
			for (int j = 0; j < 8; j++) {
				char c = s.charAt(j);
				switch (c) {
				case 'Q': white += 9; break;
				case 'q': black += 9; break;
				case 'R': white += 5; break;
				case 'r': black += 5; break;
				case 'B': case 'N': white += 3; break;
				case 'b': case 'n': black += 3; break;
				case 'P': white++; break;
				case 'p': black++; break;
				default: break;
				}
			}
		}
		System.out.println(white == black ? "Draw" : white > black ? "White" : "Black");
	}

	public static void main(String[] args) {
		new A().run();
	}

	class MyScanner {
		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
}
