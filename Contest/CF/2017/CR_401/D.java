import java.util.Scanner;

public class D {
    Scanner sc = new Scanner(System.in);

    void run() {
        int n = sc.nextInt();
        char[][] s = new char[n][];
        for (int i = 0; i < n; i++) s[i] = sc.next().toCharArray();
        if (n == 1) {
            System.out.println(String.valueOf(s[0]));
            return;
        }

        for (int i = n - 2; i >= 0; i--) {
            int l1 = s[i].length;
            int l2 = s[i + 1].length;
            boolean cut = true;
            for (int j = 0; j < Math.min(l1, l2); j++) {
                if (s[i][j] > s[i + 1][j]) {
                    s[i] = String.valueOf(s[i]).substring(0, j).toCharArray();
                    break;
                } else if (s[i][j] < s[i + 1][j]) {
                    cut = false;
                    break;
                }
            }
            l1 = s[i].length;
            l2 = s[i + 1].length;
            if (l1 > l2 && cut) s[i] = String.valueOf(s[i]).substring(0, l2).toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(String.valueOf(s[i]) + "\n");
        System.out.print(sb);
    }

    public static void main(String[] args) {
        new D().run();
    }
}
