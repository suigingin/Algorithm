import java.util.LinkedList;
import java.util.Scanner;

public class D {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n];
        int[] a = new int[m];
        for (int i = 0; i < n; i++) d[i] = sc.nextInt();
        for (int i = 0; i < m; i++) a[i] = sc.nextInt();

        int l = -1;
        int r = n;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            LinkedList<Integer> que = new LinkedList<>();
            boolean[] v = new boolean[n];
            int cnt = 0;
            int power = 0;
            for (int i = mid; i >= 0; i--) {
                if (d[i] == 0 && que.isEmpty()) continue;
                if (d[i] == 0 || v[d[i] - 1]) power++;
                else { 
                    if (!v[d[i] - 1]) que.add(a[d[i] - 1]);
                    v[d[i] - 1] = true;
                }
                if(!que.isEmpty() && que.peek() <= power) {
                    power -= que.poll();
                    cnt++;
                }
            }
            if (cnt == m) r = mid;
            else l = mid;
        }
        System.out.println((r == n) ? -1 : (r + 1));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
