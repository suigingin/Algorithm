import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] c = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) c[i] = sc.nextInt();	
		for (int i = 0; i < 5; i++) sum += c[i];
		System.out.println(sum % 5 == 0 && sum != 0 ? sum / 5 : -1);
	}

	public static void main(String[] args) {
		new A().run();
	}
}
