import java.util.Scanner;

public class A {
    Scanner sc = new Scanner(System.in);

    void run() {
        int k = sc.nextInt();
        int r = sc.nextInt();
        int res = 10;
        for (int i = 1; i <= 9; i++) {
            long mul = k * i;
            if ((mul % 10) == r || (mul % 10) == 0) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        new A().run();
    }
}
