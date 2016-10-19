import java.util.Scanner;

public class B {
    Scanner sc = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] + a[i] < k) {
                cnt += k - (a[i - 1] + a[i]);
                a[i] += k - (a[i - 1] + a[i]);
            }
        }
        StringBuilder sb = new StringBuilder(cnt+"\n");
        for (int i = 0; i < n; i++) sb.append(a[i] +" ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new B().run();
    }
}
