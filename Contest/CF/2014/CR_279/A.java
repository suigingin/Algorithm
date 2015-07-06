import java.util.ArrayList;
import java.util.Scanner;

public class A {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		ArrayList<Integer> t1 = new ArrayList<Integer>();
		ArrayList<Integer> t2 = new ArrayList<Integer>();
		ArrayList<Integer> t3 = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			int t = sc.nextInt();
			if (t == 1) t1.add(i);
			if (t == 2) t2.add(i);
			if (t == 3) t3.add(i);
		}
		int min = Math.min(t1.size(), Math.min(t2.size(), t3.size()));
		System.out.println(min);
		for (int i = 0; i < min; i++) System.out.println(t1.get(i) + " " + t2.get(i) + " " + t3.get(i));
	}

	public static void main(String[] args) {
		new A().run();
	}
}
