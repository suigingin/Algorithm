import java.util.Scanner;

public class D {
    Scanner   sc   = new Scanner(System.in);

    String o;
    char[] s,t;
    int[] a;
    int sl,tl;

    void run() {
        o = sc.next();
        s = o.toCharArray();
        t = sc.next().toCharArray();
        sl = s.length;
        tl = t.length;
        a = new int[sl];
        for (int i = 0; i < sl; i++) a[i] = sc.nextInt() - 1;

        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (ok(mid)) l = mid;
            else r = mid;
        }
        System.out.println(l);
    }

    boolean ok(int m) {
        for (int i = 0; i < m; i++) s[a[i]] = '#';
        int ti = 0;
        for (int i = 0; i < sl; i++) if(ti < t.length && s[i] == t[ti]) ti++;
        for (int i = 0; i < m; i++) s[a[i]] = o.charAt(a[i]);
        return ti == tl;
    }

    public static void main(String[] args) {
        new D().run();
    }
}
