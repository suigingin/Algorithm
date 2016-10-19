import java.util.Scanner;

public class C {
    Scanner sc = new Scanner(System.in);

    void run() {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long cnt = Long.MAX_VALUE;
        for (int i = 0; i < 1 << 3; i++) {
            long ta = (i & 1) > 0 ? a - 1 : a;
            long tb = (i & 2) > 0 ? b - 1 : b;
            long tc = (i & 4) > 0 ? c - 1 : c;
            long max = Math.max(ta, Math.max(tb, tc));
            ta -= max;
            tb -= max;
            tc -= max;
            cnt = Math.min(cnt, -ta + (-tb) + (-tc));
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        new C().run();
    }
}
