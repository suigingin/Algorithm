import java.util.Scanner;

public class B {
    Scanner   sc   = new Scanner(System.in);

    void run() {
        long n = sc.nextLong();
        long k = sc.nextLong();
        long m = (long) Math.pow(10, k);

        if (n == 0 || n % m == 0) {
            System.out.println(0);
            return;
        }

        String s = String.valueOf(n);
        int count = 1;
        while (s.length() > 0) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != '0') {
                    s = s.substring(0, i) + s.substring(i + 1, s.length());
                    break;
                }
            }
            if(Long.valueOf(s) % m == 0) {
                if(Long.valueOf(s) == 0 && s.length() > 1) count += s.length() - 1; 
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        new B().run();
    }
}
