import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class C {
    Scanner sc = new Scanner(System.in);

    class Edge {
        int e;
        int c;

        public Edge(int e, int c) {
            this.e = e;
            this.c = c;
        }
    }

    @SuppressWarnings("unchecked")
    void run() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int T = sc.nextInt();
        List<Edge> g[] = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt() - 1;
            int t = sc.nextInt() - 1;
            int c = sc.nextInt();
            g[s].add(new Edge(t, c));
        }

        TopologicalSort ts = new TopologicalSort(n, m, g);
        ts.init();
        int[] o = ts.execute();

        int[][] prev = new int[n][n + 1];
        int[][] dp = new int[n][n + 1];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], INF);
        dp[0][1] = 0;
        prev[1][1] = -1;
        for (int i = 0; i < n; i++) {
            int s = o[i];
            for (Edge e : g[s]) {
                for (int j = 0; j < n; j++) {
                    if (dp[s][j] != INF) {
                        if (dp[s][j] + e.c < dp[e.e][j + 1] && dp[s][j] + e.c <= T) {
                            dp[e.e][j + 1] = dp[s][j] + e.c;
                            prev[e.e][j + 1] = s;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[n - 1][i] <= T) ans = Math.max(ans, i);
        }

        int now = n - 1;
        int cnt = ans;
        List<Integer> l = new ArrayList<>();
        while (true) {
            l.add(now + 1);
            if (now == 0) break;
            now = prev[now][cnt--];
        }

        StringBuilder sb = new StringBuilder(String.valueOf(ans) + "\n");
        for (int i = l.size() - 1; i >= 0; i--) sb.append(l.get(i) + " ");
        System.out.println(sb);
    }

    class TopologicalSort {
        int        N, M, index;
        int[]      indeg, res;
        boolean[]  V;
        List<Edge> G[];

        public TopologicalSort(int n, int m, List<Edge> g[]) {
            super();
            N = n;
            M = m;
            G = g;
        }

        void init() {
            indeg = new int[N];
            V = new boolean[N];
            res = new int[N];
            index = 0;
            for (int i = 0; i < N; i++) {
                for (Edge e : G[i]) {
                    indeg[e.e]++;
                }
            }
        }

        int[] execute() {
            for (int u = 0; u < N; u++) {
                if (indeg[u] == 0 && !V[u]) {
                    bfs(u);
                }
            }
            return res;
        }

        void bfs(int s) {
            V[s] = true;
            LinkedList<Integer> que = new LinkedList<>();
            que.add(s);
            while (!que.isEmpty()) {
                int u = que.poll();
                res[index++] = u;
                for (Edge v : G[u]) {
                    indeg[v.e]--;
                    if (indeg[v.e] == 0 && !V[v.e]) {
                        que.add(v.e);
                        V[v.e] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new C().run();
    }
}
