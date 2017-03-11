import java.util.Arrays;
import java.util.Scanner;

public class C {
    Scanner sc = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] u = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(u[i], 1);
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                if (a[j][i] <= a[j + 1][i]) {
                    u[j][i] += u[j + 1][i];
                }
            }
        }
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 1;
            for (int j = 0; j < m; j++) {
                t = Math.max(t, u[i][j]);
            }
            max[i] = t;
        }

        StringBuilder sb = new StringBuilder();
        int k = sc.nextInt();
        while (k-- > 0) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            sb.append((r - l + 1) <= max[l] ? "Yes\n" : "No\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        new C().run();
    }
}
