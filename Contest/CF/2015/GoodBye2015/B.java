import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		long a = sc.nextLong();
		long b = sc.nextLong();
		int minL = Long.toBinaryString(a).length();
		int maxL = Long.toBinaryString(b).length();
		int cnt = 0;
		for (int i = minL; i <= maxL; i++) {
			StringBuilder binary = new StringBuilder();
			for (int j = 0; j < i; j++) binary.append("1");
			for (int j = 1; j < binary.length(); j++) {
				binary.replace(j, j + 1, "0");
				long toLong = Long.valueOf(binary.toString(), 2);
				if (a <= toLong && toLong <= b) cnt++;
				binary.replace(j, j + 1, "1");
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
