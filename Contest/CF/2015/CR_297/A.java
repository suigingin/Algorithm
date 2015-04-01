import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		char[] f = sc.next().toCharArray();
		char[] keys = new char[26];
		int cnt = 0;
		for (int i = 0; i < n * 2 - 2; i += 2) {
			char key = f[i];
			char door = (char) (f[i + 1] ^ 32);
			keys[key - 'a']++;
			if (keys[door - 'a'] > 0) {
				keys[door - 'a']--;
			} else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
