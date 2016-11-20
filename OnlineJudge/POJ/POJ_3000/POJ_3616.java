package pr_3000;

import java.util.Arrays;
import java.util.Scanner;

public class POJ_3616 {
    Scanner sc = new Scanner(System.in);

    @SuppressWarnings("unused")
    void run() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        Pair[] p = new Pair[M + 1];
        for (int i = 0; i < M; i++) p[i] = new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt());
        p[M] = new Pair(2000001, 2000002, 0);
        Arrays.sort(p);
        int[] dp = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = i + 1; j <= M; j++) {
                if (p[i].t + R <= p[j].s) {
                    dp[j] = Math.max(dp[j], dp[i] + p[i].e);
                }
            }
        }
        System.out.println(dp[M]);
    }

    class Pair implements Comparable<Pair> {

        int s;
        int t;
        int e;

        public Pair(int s, int t, int e) {
            super();
            this.s = s;
            this.t = t;
            this.e = e;
        }

        @Override
        public int compareTo(Pair arg0) {
            if (this.s == arg0.s) {
                return this.t - arg0.t;
            }
            return this.s - arg0.s;
        }
    }

    public static void main(String[] args) {
        new POJ_3616().run();
    }
}
