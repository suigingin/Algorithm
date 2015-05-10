import java.util.ArrayList;
import java.util.Scanner;

public class Similars {
	Scanner sc = new Scanner(System.in);

	public int maxsim(int L, int R) {
		int max = 0;
		int[] mask = new int[R + 1];
		for (int i = L; i <= R; i++) {
			int bid = 0;
			for (int d : getDigit(i)) {
				bid |= (1 << d);
			}
			mask[i] = bid;
			for (int j = i - 1; j >= L && i - j <= 100; j--) {
				max = Math.max(max, Integer.bitCount(mask[i] & mask[j]));
			}
		}
		return max;
	}

	ArrayList<Integer> getDigit(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (n > 0) {
			res.add(n % 10);
			n /= 10;
		}
		return res;
	}
}
