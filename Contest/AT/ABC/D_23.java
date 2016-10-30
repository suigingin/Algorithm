import java.util.Arrays;
import java.util.Scanner;

public class D_23 {
    Scanner sc = new Scanner(System.in);

    long[]  h, s;
    int     N;

    void run() {
        N = sc.nextInt();
        h = new long[N];
        s = new long[N];
        for (int i = 0; i < N; i++) {
            h[i] = sc.nextLong();
            s[i] = sc.nextLong();
        }
        long l = -1;
        long r = Long.MAX_VALUE / 2;
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (isEnable(mid)) r = mid;
            else l = mid;
        }
        System.out.println(r);
    }

    boolean isEnable(long mid) {
        long[] sec = new long[N];
        for (int i = 0; i < N; i++) {
            if (mid - h[i] < 0) return false;
            sec[i] = (mid - h[i]) / s[i];
        }
        Arrays.sort(sec);
        for (int i = 0; i < N; i++) {
            if (sec[i] < i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new D_23().run();
    }
}
