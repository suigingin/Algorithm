import java.util.Scanner;

public class AOJ_0595 {
	Scanner sc = new Scanner(System.in);
	final int MOD = 10007;

	void run() {
		int N = sc.nextInt();
		String S = sc.next();
		int[][] dp = new int[N][1 << 3];
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				for (int j = 0; j < 8; j++) {
					if ((j & 1) > 0 && (j & c_to_i(S.charAt(0))) > 0) {
						dp[i][j] = 1;
					}
				}
			} else {
				for (int j = 0; j < 8; j++) {
					for (int k = 0; k < 8; k++) {
						if ((j & k) > 0 && (k & c_to_i(S.charAt(i))) > 0) {
							dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD;
						}
					}
				}
			}
		}
		int ans = 0;
		for(int i=0;i<8;i++) ans = (ans + dp[N-1][i]) % MOD;
		System.out.println(ans);
	}

	int c_to_i(char c) {
		switch (c) {
		case 'J': return 1;
		case 'O': return 2;
		case 'I': return 4;
		}
		return -1;
	}

	public static void main(String[] args) {
		new AOJ_0595().run();
	}
}
