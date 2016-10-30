import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
    Scanner         sc  = new Scanner(System.in);
    final int       MOD = 1000000007;
    int             N;
    long[][]        dp;
    List<Integer>[] l;

    @SuppressWarnings("unchecked")
    void run() {
        N = sc.nextInt();
        l = new ArrayList[N];
        dp = new long[N][2];
        for (int i = 0; i < N; i++) l[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            l[a].add(b);
            l[b].add(a);
        }
        dfs(0, -1);
        System.out.println((dp[0][0] + dp[0][1]) % MOD);
    }

    void dfs(int now, int prev) {
        dp[now][0] = 1;
        dp[now][1] = 1;
        for (int e : l[now]) {
            if (e == prev) continue;
            dfs(e, now);
            dp[now][0] *= (dp[e][0] + dp[e][1]);
            dp[now][1] *= dp[e][0];
            dp[now][0] %= MOD;
            dp[now][1] %= MOD;
        }
    }

    public static void main(String[] args) {
        new D().run();
    }
}
