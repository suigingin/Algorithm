import java.util.Scanner;

public class A {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        int[] ca = new int[6];
        int[] cb = new int[6];
        for (int i = 0; i < n; i++) {
            ca[a[i]] ++;
            cb[b[i]] ++;
        }
        for (int i = 0; i < 6; i++) {
            if ((ca[i] + cb[i]) % 2 == 1) {
                System.out.println(-1);
                return;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 6; i++) cnt += Math.abs(ca[i] - cb[i]) / 2;
        System.out.println(cnt / 2);
    }

    public static void main(String[] args) {
        new A().run();
    }
}
