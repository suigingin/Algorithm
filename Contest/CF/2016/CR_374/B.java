import java.util.Arrays;
import java.util.Scanner;

public class B {
    Scanner sc = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            p[i] = new Pair(s.length(), s);
        }
        String pass = sc.next();
        Arrays.sort(p);

        // solve min
        int min = 1;
        int fail = 0;
        for (int i = 0; i < n; i++) {
            if (p[i].len == pass.length()) break;
            min++;
            fail++;
            if (fail >= k) {
                fail = 0;
                min += 5;
            }
        }

        // solve max
        int max = 0;
        fail = 0;
        for (int i = 0; i < n; i++) {
            if (p[i].len == pass.length()) {
                int sameCnt = 0;
                while (i < n && p[i].len == pass.length()) {
                    sameCnt++;
                    i++;
                }
                max += sameCnt;
                max += (--sameCnt + fail) / k * 5;
                break;
            } else {
                max++;
                fail++;
                if (fail >= k) {
                    fail = 0;
                    max += 5;
                }
            }
        }
        System.out.println(min + " " + max);
    }

    class Pair implements Comparable<Pair> {

        int    len;
        String S;

        public Pair(int len, String S) {
            super();
            this.len = len;
            this.S = S;
        }

        @Override
        public int compareTo(Pair arg0) {
            return this.len - arg0.len;
        }
    }

    public static void main(String[] args) {
        new B().run();
    }
}
