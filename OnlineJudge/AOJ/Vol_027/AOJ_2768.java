import java.util.Scanner;

public class AOJ_2768 {
    Scanner sc = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int[] t = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            s += t[i];
        }
        boolean[][][] dp = new boolean[n + 1][s + 1][s + 1];
        dp[0][0][0] = true;
        int min = s;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s + 1; j++) {
                for (int k = 0; k < s + 1; k++) {
                    dp[i + 1][j][k] |= dp[i][j][k];
                    if (j + t[i] <= s) dp[i + 1][j + t[i]][k] |= dp[i][j][k];
                    if (k + t[i] <= s) dp[i + 1][j][k + t[i]] |= dp[i][j][k];
                    if (dp[n][j][k]) min = Math.min(min, Math.max(j, Math.max(k, s - (j + k))));
                }
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        new AOJ_2768().run();
    }
}
