import java.util.Scanner;

public class No_046 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(b / a + ((b % a != 0) ? 1 : 0));
	}

	public static void main(String[] args) {
		new No_046().run();
	}
}
