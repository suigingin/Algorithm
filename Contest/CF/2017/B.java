import java.util.Arrays;
import java.util.Scanner;

public class B {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();

        // find minimum
        Arrays.sort(s);
        Arrays.sort(t);
        int ti = 0;
        int si = 0;
        while (true) {
            while (ti < n && s[si] > t[ti]) ti++;
            if (ti == n) break;
            else {
                si++;
                ti++;
            }
        }
        System.out.println(n - si);

        // find maximum
        ti = si = 0;
        while (true) {
            while (ti < n && s[si] >= t[ti]) ti++;
            if (ti == n) break;
            else {
                si++;
                ti++;
            }
        }
        System.out.println(si);
    }

    public static void main(String[] args) {
        new B().run();
    }
}
