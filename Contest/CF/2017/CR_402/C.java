import java.util.Arrays;
import java.util.Scanner;

public class C {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) p[i] = new Pair(a[i] - b[i], i);
        Arrays.sort(p);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i].div < 0 || p[i].div >= 0 && k > 0) ans += a[p[i].id];
            else ans += b[p[i].id];
            k--;
        }
        System.out.println(ans);
    }

    class Pair implements Comparable<Pair> {

        int div;
        int id;

        public Pair(int div, int id) {
            super();
            this.div = div;
            this.id = id;
        }

        @Override
        public int compareTo(Pair arg0) {
            if (this.div == arg0.div) {
                return this.id - arg0.id;
            }
            return this.div - arg0.div;
        }
    }

    public static void main(String[] args) {
        new C().run();
    }
}
