package CR_315;

import java.util.Arrays;
import java.util.Scanner;

public class C {
	Scanner sc = new Scanner(System.in);

	void run() {
		boolean[] isPrime = new boolean[2000001];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= 2000000; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * 2; j <= 2000000; j += i) isPrime[j] = false;
		}

		int[] pai = new int[2000001];
		int[] rub = new int[2000001];
		for (int i = 1; i <= 2000000; i++) {
			pai[i] = isPrime[i] ? pai[i - 1] + 1 : pai[i - 1];
			rub[i] = palindrome(i + "") ? rub[i - 1] + 1 : rub[i - 1];
		}

		double p = sc.nextDouble();
		double q = sc.nextDouble();

		int max = -1;
		for (int i = 1; i <= 2000000; i++) {
			if (pai[i] <= (p / q) * rub[i]) max = i;
		}
		System.out.println(max < 0 ? "Palindromic tree is better than splay tree" : max);
	}

	public static void main(String[] args) {
		new C().run();
	}

	boolean palindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}