import java.util.Scanner;

public class A {
    Scanner sc = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        char[] c = sc.next().toCharArray();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (c[i] == 'B') {
                int tmp = 0;
                cnt++;
                while (i < n && c[i] == 'B') {
                    i++;
                    tmp++;
                }
                sb.append(tmp + " ");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        new A().run();
    }
}
