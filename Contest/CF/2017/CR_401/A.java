import java.util.Scanner;

public class A {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        int n = sc.nextInt() % 6;
        int x = sc.nextInt();
        int[][] p = { 
                    { 0, 1, 2 },
                    { 1, 0, 2 },
                    { 1, 2, 0 },
                    { 2, 1, 0 },
                    { 2, 0, 1 },
                    { 0, 2, 1 },
                };
        System.out.println(p[n][x]);
    }

    public static void main(String[] args) {
        new A().run();
    }
}
