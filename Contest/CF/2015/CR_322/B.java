import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
	Scanner sc = new Scanner(System.in);

	void run() {
		int n = sc.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < n; i++) h[i] = sc.nextInt();
		ArrayList<Integer> l = new ArrayList<Integer>();
		int max = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (h[i] <= max) l.add(max - h[i] + 1);
			else l.add(0);
			max = Math.max(max, h[i]);
		}
		Collections.reverse(l);
		StringBuilder out = new StringBuilder();
		for (Integer ele : l) out.append(ele + " ");
		System.out.println(out);
	}

	public static void main(String[] args) {
		new B().run();
	}
}
