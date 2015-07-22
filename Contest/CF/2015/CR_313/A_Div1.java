import java.util.Scanner;

public class A_Div1 {
	Scanner sc = new Scanner(System.in);

	void run() {
		int[] a = new int[6];
		for (int i = 0; i < 6; i++) a[i] = sc.nextInt();
		int triangles = (a[0] + a[1] + a[2]) * (a[0] + a[1] + a[2]);
		System.out.println(triangles - a[0] * a[0] - a[2] * a[2] - a[4] * a[4]);
	}

	public static void main(String[] args) {
		new A_Div1().run();
	}
}
