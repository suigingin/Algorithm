import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class D {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int[] Y = new int[n];
        int[][] y = new int[n][32];
        for (int i = 0; i < n; i++) Y[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Arrays.fill(y[i], 1000000010);
            List<Integer> l = new ArrayList<>();
            int yy = Y[i];
            while (yy > 0) {
                l.add(yy);
                yy /= 2;
            }
            for (int j = l.size() - 1; j >= 0; j--) y[i][l.size() - j - 1] = l.get(j);
        }

        int l = 0;
        int r = 1000000001;
        int[] x = new int[n];
        while (r - l > 1) {
            // mid以下の集合を構成可能か
            int mid = (l + r) / 2;
            if (check(Y, y, x, mid)) r = mid;
            else l = mid;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) out.append(x[i] +" ");
        System.out.println(out);
    }

    boolean check(int[] Y, int[][] y, int[] x, int mid) {
        Set<Integer> set = new HashSet<>();
        int[] tmp = new int[Y.length];
        for (int i = 0; i < Y.length; i++) {
            boolean f = false;
            for (int j = 31; j >= 0; j--) {
                if (y[i][j] <= Y[i] && y[i][j] <= mid && !set.contains(y[i][j])) {
                    set.add(y[i][j]);
                    tmp[i] = y[i][j];
                    f = true;
                    break;
                }
            }
            if(!f) return false;
        }
        for (int i = 0; i < Y.length; i++) x[i] = tmp[i];
        return true;
    }

    public static void main(String[] args) {
        new D().run();
    }
}
